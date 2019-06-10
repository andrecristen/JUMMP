package JUMMP.utils;

import JUMMP.authorization.SessionAuth;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import JUMMP.frames.InstanceGridActionsFrame;
import java.awt.Toolkit;
import main.Home;
import views.grids.CarregamentoGrid;
import views.grids.EnderecoGrid;
import views.grids.EntregaGrid;
import views.grids.FilialGrid;
import views.grids.PessoaFisicaGrid;
import views.grids.PessoaGrid;
import views.grids.PessoaJuridicaGrid;
import views.grids.TransportadoraRedespachoGrid;
import views.grids.VeiculoGrid;
import views.grids.VolumeGrid;
import views.grids.UsuarioGrid;

/**
 *
 * @author Lucas Levi Gonçalves
 */
public class Menu extends JFrame {

    public Menu() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new Action("Adicionar", "add", "addPersist", false, false, "addIcon.png"));
        actions.add(new Action("Editar", "edit", "editPersist", true, false, "editIcon.png"));
        actions.add(new Action("Visualizar", "view", "", true, false, "findIcon.png"));
        actions.add(new Action("Excluir", "delete", "", true, true, "removeIcon.png"));

        setTitle(Home.getSystemName());
        Toolkit t = Toolkit.getDefaultToolkit();
        setSize(t.getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);

        // Cria uma barra de menu para o JFrame
        JMenuBar menuBar = new JMenuBar();

        //Adiciona a barra de menu ao  frame
        setJMenuBar(menuBar);

        JMenu crudMenu = new JMenu("CRUD");
        JMenu relatoriosMenu = new JMenu("Relatórios");
        JMenu consultaAdmMenu = new JMenu("Consultas - Administrador");
        JMenu verifVeiculosMenu = new JMenu("Verificar veículos");
        JMenu cargasMenu = new JMenu("Cargas");
        JMenu consultaEntregaMenu = new JMenu("Consultar Entregas");
        JMenu estatisticasMenu = new JMenu("Estatísticas");
        JMenuItem sairMenu = new JMenuItem("Sair");

        //Coloca na barra de menu
        menuBar.add(estatisticasMenu);
        menuBar.add(crudMenu);
        menuBar.add(consultaAdmMenu);
        menuBar.add(verifVeiculosMenu);
        menuBar.add(cargasMenu);
        menuBar.add(relatoriosMenu);
        menuBar.add(consultaEntregaMenu);
        menuBar.add(sairMenu);

        sairMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                sairMenu.getParent().setVisible(false);
                SessionAuth autorization = new SessionAuth();
                autorization.logout();
            }
        });

        // Cria e adiciona um item para o menu
        JMenuItem carregamento = new JMenuItem("Carregamento");

        carregamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame frameCarregamento = new InstanceGridActionsFrame("Carregamentos", new CarregamentoGrid(), actions);
                frameCarregamento.display();
            }
        });

        JMenuItem entregaCrud = new JMenuItem("Entrega");
        entregaCrud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame frameEntrega = new InstanceGridActionsFrame("Entregas", new EntregaGrid(), actions);
                frameEntrega.display();
            }
        });
        
        JMenuItem endereco = new JMenuItem("Endereço");
        endereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame frameEntrega = new InstanceGridActionsFrame("Entregas", new EnderecoGrid(), actions);
                frameEntrega.display();
            }
        });
        
        //abaixo são adicionados todos os itens do menu e seus respectivos
        //listeners para clique com suas ações a serem executadas
        JMenuItem filial = new JMenuItem("Filial");
        filial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame frameFilial = new InstanceGridActionsFrame("Filiais", new FilialGrid(), actions);
                frameFilial.display();
            }
        });

        JMenuItem pessoa = new JMenuItem("Pessoa");
        pessoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame framePessoa = new InstanceGridActionsFrame("Pessoas", new PessoaGrid(), actions);
                framePessoa.display();
            }
        });
        
        JMenuItem pessoaFisica = new JMenuItem("Pessoa Fisica");
        pessoaFisica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame framePessoa = new InstanceGridActionsFrame("Pessoas Fisicas", new PessoaFisicaGrid(), actions);
                framePessoa.display();
            }
        });
        
        JMenuItem pessoaJuridica = new JMenuItem("Pessoa Juridica");
        pessoaJuridica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame framePessoa = new InstanceGridActionsFrame("Pessoas Juridicas", new PessoaJuridicaGrid(), actions);
                framePessoa.display();
            }
        });

        JMenuItem usuario = new JMenuItem("Usuário");
        usuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame frameUsuario = new InstanceGridActionsFrame("Usuário", new UsuarioGrid(), actions);
                frameUsuario.display();
            }
        });

        JMenuItem veiculo = new JMenuItem("Veiculo");
        veiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame frameVeiculo = new InstanceGridActionsFrame("Veiculos", new VeiculoGrid(), actions);
                frameVeiculo.display();
            }
        });

        JMenuItem volume = new JMenuItem("Volume");
        volume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame frameVolume = new InstanceGridActionsFrame("Volume", new VolumeGrid(), actions);
                frameVolume.display();
            }
        });

        JMenuItem clientes = new JMenuItem("Clientes");
        clientes.addActionListener((action) -> {

        });

        JMenuItem consulta_veiculos = new JMenuItem("Veiculos");
        consulta_veiculos.addActionListener((action) -> {

        });

        JMenuItem motoristas = new JMenuItem("Motoristas");
        motoristas.addActionListener((action) -> {

        });

        JMenuItem entregas = new JMenuItem("Entregas");
        entregas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame frameEntrega = new InstanceGridActionsFrame("Entregas", new EntregaGrid(), actions);
                frameEntrega.display();
            }
        });

        JMenuItem volumes = new JMenuItem("Volumes");
        volumes.addActionListener((action) -> {

        });

        JMenuItem entregaConsult = new JMenuItem("Consultar entrega");
        entregaConsult.addActionListener((action) -> {

        });

        JMenuItem transportadora = new JMenuItem("Trasportadora Redespacho");
        transportadora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                InstanceGridActionsFrame frameRedespacho = new InstanceGridActionsFrame("Transportadoras Redespacho", new TransportadoraRedespachoGrid(), actions);
                frameRedespacho.display();
            }
        });

        JMenuItem veiculosReparo = new JMenuItem("Veículos em reparo");
        JMenuItem veiculosAguardandoReparo = new JMenuItem("Veículos aguardando reparo");

        JMenuItem estatisticasGraficos = new JMenuItem("Gráficos");
        JMenuItem estatisticasContadores = new JMenuItem("Contadores");
        
        crudMenu.add(carregamento);
        crudMenu.add(entregaCrud);
        crudMenu.add(endereco);
        crudMenu.add(filial);
        crudMenu.add(pessoa);
        crudMenu.add(pessoaFisica);
        crudMenu.add(pessoaJuridica);
        crudMenu.add(usuario);
        crudMenu.add(veiculo);
        crudMenu.add(volume);
        crudMenu.add(transportadora);

        verifVeiculosMenu.add(veiculosReparo);
        verifVeiculosMenu.add(veiculosAguardandoReparo);

        consultaAdmMenu.add(clientes);
        consultaAdmMenu.add(consulta_veiculos);
        consultaAdmMenu.add(motoristas);
        consultaAdmMenu.add(entregas);
        consultaAdmMenu.add(volumes);

        consultaEntregaMenu.add(entregaConsult);

        estatisticasMenu.add(estatisticasGraficos);
        estatisticasMenu.add(estatisticasContadores);
    }
}
