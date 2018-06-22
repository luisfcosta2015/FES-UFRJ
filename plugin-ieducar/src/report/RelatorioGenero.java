package report;

import net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder;
import net.sf.dynamicreports.report.builder.chart.Pie3DChartBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.*;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import static net.sf.dynamicreports.report.builder.DynamicReports.cht;

public class RelatorioGenero {

    String escola;
    String turma;

    int m; // Somatório de meninos
    int f; //Somatório de meninas

    String[] genero = new String[3];

    public RelatorioGenero(String e, String t) {
        this.escola = e;
        this.turma = t;

        this.m = 0;
        this.f = 0;

        this.genero[0] = "Feminino";
        this.genero[1] = "Feminino";
        this.genero[2] = "Feminino";
    }

    StyleBuilder boldStyle = stl.style().bold();
    StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
    StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
            .setBorder(stl.pen1Point())
            .setBackgroundColor(Color.LIGHT_GRAY);

    TextColumnBuilder<String> turmaColuna = col.column("Turma", "turma", type.stringType()).setStyle(boldCenteredStyle);

    TextColumnBuilder<String> generoColuna = col.column("Gênero", "genero", type.stringType()).setStyle(boldCenteredStyle); //key grafico de pizza
    TextColumnBuilder<Integer> quantidade = col.column("Alunos Errados", "qtd", type.integerType()); //Guardar o somatório de meninos e meninas para o gráfico de pizza
    TextColumnBuilder<Integer> masculinoColuna = col.column("Masculino", "masculino", type.integerType()); //key grafico de barra
    TextColumnBuilder<Integer> femininoColuna = col.column("Feminino", "feminino", type.integerType()); //key grafico de barra


    TextColumnBuilder<String> alunoColuna = col.column("Aluno", "aluno", type.stringType()).setStyle(boldCenteredStyle);
    TextColumnBuilder<String> registroColuna = col.column("Registro", "registro", type.stringType()).setStyle(boldCenteredStyle);
    TextColumnBuilder<Integer> rowNumberColumn = col.reportRowNumberColumn("No.")
            .setFixedColumns(2)
            .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);

    //Gráfco de Barra
    Bar3DChartBuilder graficoBarra = cht.bar3DChart()
            .setTitle("Comparativo entre menino e meninas nas turmas")
            .setCategory(turmaColuna) //Eixo X
            .addSerie(cht.serie(masculinoColuna), cht.serie(femininoColuna));

    //Gráfico de Pizza
    Pie3DChartBuilder graficoPizza = cht.pie3DChart()
            .setTitle("Alunos na série errada")
            .setKey(generoColuna)
            .series(cht.serie(quantidade));

    public void buildBarra() {
        try {
            report()
                    .setColumnTitleStyle(columnTitleStyle)
                    .setSubtotalStyle(boldStyle)
                    .highlightDetailEvenRows()

                    .columns(// add columns
                            rowNumberColumn, alunoColuna, generoColuna, turmaColuna, registroColuna)



                    .title(cmp.text("Relatório sobre " + this.escola + " da turma " + this.turma))
                    .pageFooter(cmp.pageXofY())
                    .summary(graficoBarra)
                    .setDataSource(createBarraSource())
                    .show();

        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    public JRDataSource createBarraSource() {
        DRDataSource dataSource = new DRDataSource("aluno", "genero", "turma", "registro", "feminino", "masculino");
        //Pensando na Quarta série

        for (int i = 0; i < this.genero.length; i++) {
            if (genero[i].equals("Feminino")) {
                dataSource.add("Aluno 1", "Feminino", this.turma, "ABC", 1, 0);
            }

            else {
                dataSource.add("Aluno 1", "Masculino", this.turma, "ABC", 0, 1);

            }
        }

        return dataSource;
    }


    public void buildPizza() {
        try {
            report()
                    .setColumnTitleStyle(columnTitleStyle)
                    .setSubtotalStyle(boldStyle)
                    .highlightDetailEvenRows()

                    .columns(// add columns
                            generoColuna, quantidade)



                    .title(cmp.text("Relatório sobre "))
                    .pageFooter(cmp.pageXofY())
                    .summary(graficoPizza)
                    .setDataSource(createPizzaSource())
                    .show();

        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    public JRDataSource createPizzaSource() {
        DRDataSource dataSource = new DRDataSource("genero", "qtd");


        for (int i = 0; i < this.genero.length; i++) {
            if (genero[i].equals("Feminino")) {
                this.f = this.f + 1;
            }

            else {
                this.m = this.m + 1;

            }
        }

        dataSource.add("Meninas na Turma", this.f);
        dataSource.add("Meninos na Turma", this.m);
        return dataSource;
    }
}
