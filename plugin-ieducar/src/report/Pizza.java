package report;

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

    public Pizza() {
        intArray[0] = 1;
        intArray[1] = 11;
        intArray[2] = 10;
    }

    public void buildPizza(String escola, String turma) {
        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);

        TextColumnBuilder<String> turmaColuna = col.column("Turma", "turma", type.stringType()).setStyle(boldStyle);
        TextColumnBuilder<Integer> idadeColuna = col.column("Idade", "idade", type.integerType());

        TextColumnBuilder<Integer> quantidadeCerta = col.column("Alunos Certos", "qtdCerta", type.integerType());
        TextColumnBuilder<Integer> quantidadeErrada = col.column("Alunos Errados", "qtdErrada", type.integerType());

        TextColumnBuilder<String> alunoColuna = col.column("Aluno", "aluno", type.stringType());
        TextColumnBuilder<String> registroColuna = col.column("Registro", "registro", type.stringType());
        TextColumnBuilder<Integer> rowNumberColumn = col.reportRowNumberColumn("No.")
                .setFixedColumns(2)
                .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);

        PieChartBuilder graficoPizza = cht.pieChart()
                .setTitle("Alunos na série errada")
                .setKey(turmaColuna)
                .series(cht.serie(quantidadeCerta), cht.serie(quantidadeErrada));

        try {
            report()
                    .setColumnTitleStyle(columnTitleStyle)
                    .setSubtotalStyle(boldStyle)
                    .highlightDetailEvenRows()

                    .columns(// add columns
                            rowNumberColumn, alunoColuna, idadeColuna, turmaColuna, registroColuna)



                    .title(cmp.text("Relatório sobre " + escola + " da turma " + turma))
                    .pageFooter(cmp.pageXofY())
                    .summary(graficoPizza)
                    .setDataSource(createDataSource(turma))
                    .show();

        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    public JRDataSource createDataSource(String turma) {
        DRDataSource dataSource = new DRDataSource("aluno", "idade", "turma", "registro", "qtdCerta", "qtdErrada");
        //Pensando na Quarta série

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > 7) {
                dataSource.add("Aluno 1", intArray[i], turma, "ABC", 0, 1);
            } else {
                dataSource.add("Aluno 1", intArray[i], turma, "ABC", 1, 0);
            }
        }

        return dataSource;
    }

    public static void main(String[] args) {
        Pizza p = new Pizza();
        p.buildPizza("Escola", "Turma");
    }

}
