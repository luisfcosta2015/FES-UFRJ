package report;

import net.sf.dynamicreports.report.builder.chart.Pie3DChartBuilder;
import net.sf.dynamicreports.report.builder.chart.PieChartBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.*;


import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

public class Pizza {
    int[] intArray = new int[3];
    int errado;
    int certo;
    public Pizza() {
        intArray[0] = 1; //Escola 0
        intArray[1] = 5; //Escola 0
        intArray[2] = 10; //Escola 1

        certo = 0;
        errado = 0;
    }

    public void buildPizza(String escola, String turma) {
        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);

        TextColumnBuilder<String> turmaColuna = col.column("Turma", "turma", type.stringType()).setStyle(boldStyle);
        TextColumnBuilder<String> verificaColuna = col.column("Verifica", "verifica", type.stringType()).setStyle(boldStyle);
        TextColumnBuilder<Integer> idadeColuna = col.column("Idade", "idade", type.integerType());


        //TextColumnBuilder<Integer> quantidadeCerta = col.column("Alunos Certos", "qtdCerta", type.integerType());
        //TextColumnBuilder<Integer> quantidadeErrada = col.column("Alunos Errados", "qtdErrada", type.integerType());
        TextColumnBuilder<Integer> quantidade = col.column("Alunos Errados", "qtd", type.integerType());


        TextColumnBuilder<String> alunoColuna = col.column("Aluno", "aluno", type.stringType());
        TextColumnBuilder<String> registroColuna = col.column("Registro", "registro", type.stringType());
        TextColumnBuilder<Integer> rowNumberColumn = col.reportRowNumberColumn("No.")
                .setFixedColumns(2)
                .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);

        Pie3DChartBuilder graficoPizza = cht.pie3DChart()
                .setTitle("Alunos na série errada")
                .setKey(verificaColuna)
                .series(cht.serie(quantidade));

        try {
            report()
                    .setColumnTitleStyle(columnTitleStyle)
                    .setSubtotalStyle(boldStyle)
                    .highlightDetailEvenRows()

                    .columns(// add columns
                            verificaColuna, quantidade)



                    .title(cmp.text("Relatório sobre "))
                    .pageFooter(cmp.pageXofY())
                    .summary(graficoPizza)
                    .setDataSource(createDataSource())
                    .show();

        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    public JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("verifica", "qtd");


        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > 7) {
                errado = errado + 1;
                //dataSource.add("Aluno 1", intArray[i], "turma", "ABC");
            } else {
                certo = certo + 1;
                //dataSource.add("Aluno 1", intArray[i], "turma", "ABC");
            }
        }

        dataSource.add("Quantidade na série Certa", certo);
        dataSource.add("Quantidade na série errada", errado);
        return dataSource;
    }

    public static void main(String[] args) {
        //Pizza p = new Pizza();
        //p.buildPizza();
    }

}