package JUMMP.controllers;

import JUMMP.connections.JPADAO;
import JUMMP.forms.BaseForm;
import JUMMP.grids.AbstractGrid;
import JUMMP.models.AbstractModel;
import JUMMP.models.ModelDefault;
import JUMMP.utils.Action;
import views.forms.FormCarregamento;
import JUMMP.utils.EventMessage;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Java Uma Merda Menos Pior - JUMMP
 *
 * @author André Cristen
 *
 * Basicamente é a classe que serve de base para outros controllers, entidade
 * que lida com interações do da tela com o banco de dados, além de
 * processamentos na info que vem e vai etc
 */
public abstract class BaseController {

    public abstract Class createInstaceModel();

    public abstract BaseForm createInstaceView();

    protected boolean add;
    //Recebe o form como parametro ja que nele temos todos as informacoes que vamos precisar
    protected BaseForm parameters;
    //Recebe o identificador de um objeto para poder buscar um objeto com esse id.
    protected long identificador;
    //Recebe a acao que esta abrindo os grid e forms no momento
    protected Action action;
    //Recebe o nome metodo get a ser para buscar o identificador do modelo, usado em 
    protected String identificadorGetMethod;

    /**
     * Deve ser implementado para passar um baseForm, e converter para um objeto
     * referente a view.
     */
    public abstract Object beanModel();

    /**
     * Deve ser implementado para passar um objeto, e setar os dados em um
     * BaseForm.
     */
    public abstract void beanForm(BaseForm view, Object model);

    /**
     * Metodo utilizado para abrir o form de insercao do objeto
     */
    public boolean add() {
        try {
            this.setAdd(true);
            BaseForm view = this.createInstaceView();
            view.setGridParent(this.action.getGridCallRefresh());
            view.setResizable(false);
            view.setActionPersist(this.action);
            view.setLocationRelativeTo(null);
            view.run();
            return true;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
            return false;
        }
    }

    /**
     * Metodo utilizado para publicar um objeto, utilizado na acao gravar do
     * form
     *
     */
    public EventMessage addPersist() {
        String message;
        int success;
        Object objeto = this.beanModel();
        JPADAO dao = new JPADAO();
        try {
            boolean sucessoOperacao = dao.persist(objeto);
            if (sucessoOperacao) {
                message = "Operação Realizada com sucesso!";
                success = EventMessage.getTIPO_SUCESSO();
                this.parameters.setVisible(false);
                this.parameters.getActionPersist().getGridCallRefresh().reloadTable();
            } else {
                message = "Erro ao realizar operação";
                success = EventMessage.getTIPO_ERRO();
            }
        } catch (Exception exception) {
            message = "Erro ao realizar operação, erro mrecebido: " + exception.getMessage() +", erro na conexao"+ dao.getLastException().getMessage();
            success = EventMessage.getTIPO_ERRO();
        }
        return new EventMessage(message, success);
    }

    /**
     * Metodo utilizado para abrir o from de edicao do objeto
     */
    public boolean edit() {
        this.setAdd(false);
        JPADAO dao = new JPADAO();
        try {
            Object objetoEncontrado = dao.findById(this.createInstaceModel(), this.getIdentificador());
            BaseForm view = this.createInstaceView();
            this.beanForm(view, objetoEncontrado);
            view.setResizable(false);
            view.setLocationRelativeTo(null);
            view.setObjeto(objetoEncontrado);
            view.run();
            return true;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
            return false;
        }

    }

    /**
     * Metodo utilizado para publicar o objeto, utilizado na acao salvar do form
     */
    public EventMessage editPersist() {
        String message;
        int success;
        Object objeto = this.beanModel();
        try {
            JPADAO dao = new JPADAO();
            boolean sucessoOperacao = dao.update(objeto);
            if (sucessoOperacao) {
                message = "Operação Realizada com sucesso!";
                success = EventMessage.getTIPO_SUCESSO();
                this.parameters.setVisible(false);
                this.parameters.getActionPersist().getGridCallRefresh().reloadTable();
            } else {
                message = "Erro ao realizar operação";
                success = EventMessage.getTIPO_ERRO();
            }
        } catch (Exception exception) {
            message = "Erro ao realizar operação, erro recebido: " + exception.getMessage();
            success = EventMessage.getTIPO_ERRO();
        }
        return new EventMessage(message, success);
    }

    public Object findById(int id){
        try {
            JPADAO dao = new JPADAO();
            Object objetoEncontrado = dao.findById(this.createInstaceModel(), id);
            return objetoEncontrado;
        } catch (Exception exception) {
            new EventMessage("Erro ao buscar modelo, ocorrido: "+exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return new Object();
    }

    /**
     * Metodo que exclui um objeto
     */
    public EventMessage delete() {
        String message;
        int success;
        try {
            JPADAO dao = new JPADAO();
            Object objetoFinded = dao.findById(this.createInstaceModel(), this.getIdentificador());
            boolean sucessoOperacao = dao.delete(objetoFinded);
            if (sucessoOperacao) {
                message = "Operação Realizada com sucesso!";
                success = EventMessage.getTIPO_SUCESSO();
                this.action.getGridCallRefresh().reloadTable();
            } else {
                message = "Erro ao realizar operação";
                success = EventMessage.getTIPO_ERRO();
            }
        } catch (Exception exception) {
            message = "Erro ao realizar operação, erro mrecebido: " + exception.getMessage();
            success = EventMessage.getTIPO_ERRO();
        }
        return new EventMessage(message, success);
    }

    /**
     * Metodo utilizado para abrir o form de visualizacao do objeto
     */
    public boolean view() {
        this.setAdd(false);
        JPADAO dao = new JPADAO();
        try {
            Object objetoFinded = dao.findById(this.createInstaceModel(), this.getIdentificador());
            BaseForm view = this.createInstaceView();
            this.beanForm(view, objetoFinded);
            view.setResizable(false);
            view.setLocationRelativeTo(null);
            view.setObjeto(objetoFinded);
            view.run();
            return true;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
            return false;
        }
    }

    public List getAllModels() {
        JPADAO dao = new JPADAO();
        List models = dao.getAll(this.createInstaceModel());
        return models;
    }

    /**
     * Retorna a lista a ser usada nos forms. Usando sempre o id como
     * identificador.
     *
     * @return
     */
    public Object[] getModelList() {
        List models = this.getAllModels();
        Class tipo = this.createInstaceModel();
        ArrayList<Object> listaFinal = new ArrayList<>();
        for (Object objeto : models) {
            try {
                Method metodo = objeto.getClass().getMethod(this.getIdentificadorGetMethod());
                listaFinal.add(metodo.invoke(objeto));
            } catch (Exception exception) {
                new EventMessage("Erro ao criar lista para o modelo, erro recebido: " + exception.getMessage(), EventMessage.getTIPO_ERRO());
            }
        }
        return listaFinal.toArray();
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public Object getParameters() {
        return parameters;
    }

    public void setParameters(BaseForm parameters) {
        this.parameters = parameters;
    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getIdentificadorGetMethod() {
        return identificadorGetMethod;
    }

    public void setIdentificadorGetMethod(String identificadorModelList) {
        this.identificadorGetMethod = identificadorModelList;
    }
}
