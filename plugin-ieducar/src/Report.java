import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

public class Report {

    public Report(){ build(); }
    private void build() {
        try {
            report()
                    .columns(
                            col.column("Aluno", "aluno", type.stringType()),
                            col.column("Turma", "turma", type.integerType()),
                            col.column("Registro", "registro", type.integerType()) )

                    .title(cmp.text("Teste de Relatório"))
                    .pageFooter(cmp.pageXofY())
                    .setDataSource(createDataSource())
                    .show();

        } catch (DRException e) {
            e.printStackTrace();
        }
    }
    private JRDataSource createDataSource(){
        DRDataSource dataSource = new DRDataSource("aluno", "turma", "registro");
        dataSource.add("Aline de Freire Rezendo", 201, 101010);
        dataSource.add("Larissa Galeno", 104, 256969);
        dataSource.add("Gilberto Lopes Pai", 303, 888888);
        dataSource.add("Gilberto Lopes Filho", 304, 555555);
        dataSource.add("Tomaz Cuber Guimarães", 95, 686868);
        return dataSource;
    }

    public static void main(String[] args){
        new Report();
    }
}

