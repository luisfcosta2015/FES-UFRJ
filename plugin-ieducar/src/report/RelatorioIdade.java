package report;

import Layout.Layout;
import net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder;
import net.sf.dynamicreports.report.builder.chart.Pie3DChartBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.*;
import java.util.*;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import static net.sf.dynamicreports.report.builder.DynamicReports.cht;

/**
 * Classe para gerar relatório do gráfico comparativo das Idades dos alunos a sua sére
 *
 */
public class RelatorioIdade {

    private String escola;
    private String turma;

    private int[] intArray = new int[3];
    DatabaseConnection db = new DatabaseConnection();
    ArrayList<Aluno> alunos;
    private int[] faixaEtaria;

    private int errado;
    private int certo;

    private boolean gerado;


    public RelatorioIdade(String e, String t) {
        this.escola = e;
        this.turma = t;

        this.errado = 0;
        this.certo = 0;

        this.gerado = false;

        intArray[0] = 1;
        intArray[1] = 11;
        intArray[2] = 10;
        alunos = db.getListaDeAlunos();
        faixaEtaria = db.getFaixaEtariaSerie();
    }

    private StyleBuilder boldStyle = stl.style().bold();
    private StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
    private StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
            .setBorder(stl.pen1Point())
            .setBackgroundColor(Color.LIGHT_GRAY);

    private TextColumnBuilder<String> turmaColuna = col.column("Turma", "turma", type.stringType()).setStyle(boldCenteredStyle);
    private TextColumnBuilder<Integer> idadeColuna = col.column("Idade", "idade", type.integerType()).setStyle(boldCenteredStyle);
    private TextColumnBuilder<String> verificaColuna = col.column("Verifica", "verifica", type.stringType()).setStyle(boldStyle); //Coluna para diferenciar o certo e o errad

    private TextColumnBuilder<Integer> quantidadeCerta = col.column("Alunos Certos", "qtdCerta", type.integerType()); //Para o cálculo do gráfico de barra
    private TextColumnBuilder<Integer> quantidadeErrada = col.column("Alunos Errados", "qtdErrada", type.integerType()); //Para o cálculo do gráfico de barra
    private TextColumnBuilder<Integer> quantidadeTotal = col.column("Alunos Errados", "qtdTotal", type.integerType()); // Para guardar o somatório do gráfico de pizza


    private TextColumnBuilder<String> alunoColuna = col.column("Aluno", "aluno", type.stringType()).setStyle(boldCenteredStyle);
    private TextColumnBuilder<String> registroColuna = col.column("Registro", "registro", type.stringType()).setStyle(boldCenteredStyle);
    private TextColumnBuilder<Integer> rowNumberColumn = col.reportRowNumberColumn("No.")
            .setFixedColumns(2)
            .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);

    //Gráfico de barra
    private Bar3DChartBuilder graficoBarra = cht.bar3DChart()
            .setTitle("Comparativo de alunos na série correta").setStyle(boldCenteredStyle)
            .setCategory(turmaColuna) //Eixo X
            .addSerie(cht.serie(quantidadeCerta), cht.serie(quantidadeErrada));

    //Gráfico de Pizza
    private Pie3DChartBuilder graficoPizza = cht.pie3DChart()
            .setTitle("Comparativo de alunos na série correta").setStyle(boldCenteredStyle)
            .setKey(verificaColuna)
            .series(cht.serie(quantidadeTotal));

    public boolean buildBarra() {
        try {
            report()
                    .setTemplate(Layout.reportTemplate)
                    .title(Layout.createTitleComponent(escola + " - " + turma))
                    .setColumnTitleStyle(columnTitleStyle)
                    .setSubtotalStyle(boldStyle)
                    .highlightDetailEvenRows()

                    .columns(// add columns
                            rowNumberColumn, alunoColuna, idadeColuna, turmaColuna, registroColuna)



                    .pageFooter(cmp.pageXofY())
                    .summary(graficoBarra)
                    .setDataSource(createBarraSource())
                    .show();

            this.gerado = true;

        } catch (DRException e) {
            e.printStackTrace();
        }

        return this.gerado;
    }

    public JRDataSource createBarraSource() {
        DRDataSource dataSource = new DRDataSource("aluno", "idade", "turma", "registro", "qtdCerta", "qtdErrada");
        //Pensando na Quarta série

        for (Aluno a : alunos) {
            String reg = String.valueOf(a.registro);
            if (a.getIdade() < faixaEtaria[0] || a.getIdade() > faixaEtaria[1]) {
                dataSource.add(a.nome, a.getIdade(), this.turma, reg, 0, 1);
            } else {
                dataSource.add(a.nome, a.getIdade(), this.turma, reg, 1, 0);

            }
        }

        return dataSource;
    }

    public boolean buildPizza() {
        try {
            report()
                    .setTemplate(Layout.reportTemplate)
                    .title(Layout.createTitleComponent(escola + " - " + turma))
                    .setColumnTitleStyle(columnTitleStyle)
                    .setSubtotalStyle(boldStyle)
                    .highlightDetailEvenRows()

                    .columns(// add columns
                            verificaColuna, quantidadeTotal)

                    .pageFooter(cmp.pageXofY())
                    .summary(graficoPizza)
                    .setDataSource(createPizzaSource())
                    .show();

            this.gerado = true;

        } catch (DRException e) {
            e.printStackTrace();
        }

        return this.gerado;
    }

    public JRDataSource createPizzaSource() {
        DRDataSource dataSource = new DRDataSource("verifica", "qtdTotal");


        for (Aluno a : alunos) {
            if (a.getIdade() < faixaEtaria[0] || a.getIdade() > faixaEtaria[1]) {
                this.errado = this.errado + 1;
            } else {
                this.certo = this.certo + 1;
            }
        }

        dataSource.add("Quantidade na série Certa", certo);
        dataSource.add("Quantidade na série errada", errado);
        return dataSource;
    }
}
