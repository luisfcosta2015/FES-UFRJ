//Antes estava foram da pasta, mas eu não souber lidar, desculpa
package report;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder;
import net.sf.dynamicreports.report.builder.column.PercentageColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.*;
import java.math.BigDecimal;

public class Report {

    Barra relatorioBarra = new Barra();

    public Report(){ //build();
    }

    public void build(String escola, String turma, String grafico) {
        if (grafico == "Barra") {
            relatorioBarra.buildBarra(escola, turma);
        }

        else {
            System.out.println("Ops, ainda não implementamos o de pizza");
        }
    }

    /*
    public void build(String escola, String turma, String grafico) { //ANTES -> era private
        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);


        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType()).setStyle(boldStyle);
        TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> priceColumn = unitPriceColumn.multiply(quantityColumn).setTitle("Price");
        PercentageColumnBuilder pricePercColumn = col.percentageColumn("Price %", priceColumn);
        TextColumnBuilder<Integer> rowNumberColumn = col.reportRowNumberColumn("No.")
                .setFixedColumns(2)
                .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);


        Bar3DChartBuilder itemChart = cht.bar3DChart()
            .setTitle("Sales by item")
            .setCategory(itemColumn)
            .addSerie(cht.serie(unitPriceColumn), cht.serie(priceColumn));




        try {
            report()

                    .setColumnTitleStyle(columnTitleStyle)
                    .setSubtotalStyle(boldStyle)
                    .highlightDetailEvenRows()
                    //.columns(
                            //col.column("Aluno", "aluno", type.stringType()),
                            //col.column("Idade", "idade", type.integerType()),
                            //col.column("Turma", "turma", type.integerType()),
                            //col.column("Registro", "registro", type.integerType()) )

                    .columns(// add columns
                            rowNumberColumn, itemColumn, quantityColumn, unitPriceColumn, priceColumn, pricePercColumn)

                    .subtotalsAtSummary(
                            sbt.sum(unitPriceColumn), sbt.sum(priceColumn))
                    .subtotalsAtFirstGroupFooter(
                            sbt.sum(unitPriceColumn), sbt.sum(priceColumn))

                    .title(cmp.text("Teste de Relatório"))
                    .pageFooter(cmp.pageXofY())
                    .summary(itemChart)
                    .setDataSource(createDataSource())
                    .show();

        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        dataSource.add("Notebook", 1, new BigDecimal(500));
        dataSource.add("DVD", 5, new BigDecimal(30));
        dataSource.add("DVD", 1, new BigDecimal(28));
        dataSource.add("DVD", 5, new BigDecimal(32));
        dataSource.add("Book", 3, new BigDecimal(11));
        dataSource.add("Book", 1, new BigDecimal(15));
        dataSource.add("Book", 5, new BigDecimal(10));
        dataSource.add("Book", 8, new BigDecimal(9));

        System.out.println(dataSource);
        return dataSource;
    }

    */

    /*
    public JRDataSource createDataSource() {

        DRDataSource dataSource = new DRDataSource("aluno", "turma", "registro");
        dataSource.add("Aline de Freire Rezendo", 201, 101010);
        dataSource.add("Larissa Galeno", 104, 256969);
        dataSource.add("Gilberto Lopes Pai", 303, 888888);
        dataSource.add("Gilberto Lopes Filho", 304, 555555);
        dataSource.add("Tomaz Cuber Guimarães", 95, 686868);


        System.out.println(dataSource);
        return dataSource;
    }
    */


}

