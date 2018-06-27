package report;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;

import Layout.Layout;
import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

public class Pie3DChartReport {
    public Pie3DChartReport() {
        build();
    }

    private void build() {

        FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());

        try {
            report()
                    .setTemplate(Layout.reportTemplate)
                    .title(Layout.createTitleComponent("Pie3DChart"))
                    .columns(itemColumn, quantityColumn, unitPriceColumn)
                    .summary(
                            cht.pie3DChart()
                                    .setTitle("Pie 3D chart")
                                    .setTitleFont(boldFont)
                                    .setKey(itemColumn)

                                    .series(
                                            cht.serie(unitPriceColumn)))
                                    //.series(
                                            //cht.serie(unitPriceColumn), cht.serie(quantityColumn)))

                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        dataSource.add("Tablet", 350, new BigDecimal(300));
        dataSource.add("Laptop", 300, new BigDecimal(500));
        dataSource.add("Smartphone", 450, new BigDecimal(250));
        return dataSource;
    }



    public static void main(String[] args) {
        new Pie3DChartReport();
    }
}
