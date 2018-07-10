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
import java.util.ArrayList;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import static net.sf.dynamicreports.report.builder.DynamicReports.cht;

/**
 * Classe para mostrar o gráfico comparativo do gênero em cada turma
 *
 */
public class RelatorioGenero {

    private String escola;
    private String turma;

    private int masculino; // Somatório de meninos
    private int feminino; //Somatório de meninas

    private boolean gerado;

    private String[] genero = new String[3];
    DatabaseConnection db = new DatabaseConnection();
    ArrayList<Aluno> alunos;

    public RelatorioGenero(String e, String t) {
        this.escola = e;
        this.turma = t;

        this.masculino = 0;
        this.feminino = 0;

        this.gerado = false;

        this.genero[0] = "Feminino";
        this.genero[1] = "Feminino";
        this.genero[2] = "Feminino";
        alunos = db.getListaDeAlunos();
    }

    private StyleBuilder boldStyle = stl.style().bold();
    private StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
    private StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
            .setBorder(stl.pen1Point())
            .setBackgroundColor(Color.LIGHT_GRAY);

    private TextColumnBuilder<String> turmaColuna = col.column("Turma", "turma", type.stringType()).setStyle(boldCenteredStyle);

    private TextColumnBuilder<String> generoColuna = col.column("Gênero", "genero", type.stringType()).setStyle(boldCenteredStyle); //key grafico de pizza
    private TextColumnBuilder<Integer> quantidade = col.column("Alunos Errados", "qtd", type.integerType()); //Guardar o somatório de meninos e meninas para o gráfico de pizza
    private TextColumnBuilder<Integer> masculinoColuna = col.column("Masculino", "qtdMasculino", type.integerType()); //key grafico de barra
    private TextColumnBuilder<Integer> femininoColuna = col.column("Feminino", "qtdFeminino", type.integerType()); //key grafico de barra


    private TextColumnBuilder<String> alunoColuna = col.column("Aluno", "aluno", type.stringType()).setStyle(boldCenteredStyle);
    private TextColumnBuilder<String> registroColuna = col.column("Registro", "registro", type.stringType()).setStyle(boldCenteredStyle);
    private TextColumnBuilder<Integer> rowNumberColumn = col.reportRowNumberColumn("No.")
            .setFixedColumns(2)
            .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);

    //Gráfco de Barra
    private Bar3DChartBuilder graficoBarra = cht.bar3DChart()
            .setTitle("Comparativo entre meninos e meninas nas turmas").setStyle(boldCenteredStyle)
            .setCategory(turmaColuna) //Eixo X
            .addSerie(cht.serie(femininoColuna), cht.serie(masculinoColuna));

    //Gráfico de Pizza
    private Pie3DChartBuilder graficoPizza = cht.pie3DChart()
            .setTitle("Comparativo entre meninas e meninos nas turmas").setStyle(boldCenteredStyle)
            .setKey(generoColuna)
            .series(cht.serie(quantidade));

    public boolean buildBarra() {
        try {
            report()
                    .setTemplate(Layout.reportTemplate)
                    .title(Layout.createTitleComponent(escola + " - " + turma))
                    .setColumnTitleStyle(columnTitleStyle)
                    .setSubtotalStyle(boldStyle)
                    .highlightDetailEvenRows()

                    .columns(// add columns
                            rowNumberColumn, alunoColuna, generoColuna, turmaColuna, registroColuna)


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
        DRDataSource dataSource = new DRDataSource("aluno", "genero", "turma", "registro", "qtdFeminino", "qtdMasculino");
        //Pensando na Quarta série

        for (Aluno a : this.alunos) {
            String reg = String.valueOf(a.registro);
            if (a.genero.equals("F")) {
                dataSource.add(a.nome, "Feminino", this.turma, reg, 1, 0);
            } else {
                dataSource.add(a.nome, "Masculino", this.turma, reg, 0, 1);

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
                            generoColuna, quantidade)



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
        DRDataSource dataSource = new DRDataSource("genero", "qtd");

        for (Aluno a : this.alunos) {
            if (a.genero.equals("F")) {
                this.feminino = this.feminino + 1;
            } else {
                this.masculino = this.masculino + 1;

            }
        }

        dataSource.add("Meninas na Turma", this.feminino);
        dataSource.add("Meninos na Turma", this.masculino);
        return dataSource;
    }
}
