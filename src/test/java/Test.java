import entity.GeneralColumn;
import entity.GeneralTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zcfrank1st on 8/13/15.
 */
public class Test {
    public static void main(String[] args) {
        GeneralTable generalTable = new GeneralTable();
        List<GeneralColumn> generalColumnList = new ArrayList<GeneralColumn>();
        GeneralColumn generalColumn = new GeneralColumn();

        generalColumn.setComment("a");
        generalColumn.setIndex("0");
        generalColumn.setName("id");
        generalColumn.setType("varchar(20)");

        GeneralColumn generalColumn1 = new GeneralColumn();
        generalColumn1.setComment("a");
        generalColumn1.setIndex("0");
        generalColumn1.setName("id");
        generalColumn1.setType("varchar(20)");

        GeneralColumn generalColumn2 = new GeneralColumn();
        generalColumn2.setComment("a");
        generalColumn2.setIndex("0");
        generalColumn2.setName("id");
        generalColumn2.setType("varchar(20)");

        GeneralColumn generalColumn3 = new GeneralColumn();
        generalColumn3.setComment("a");
        generalColumn3.setIndex("0");
        generalColumn3.setName("id");
        generalColumn3.setType("string");

        GeneralColumn generalColumn4 = new GeneralColumn();
        generalColumn4.setComment("a");
        generalColumn4.setIndex("0");
        generalColumn4.setName("id");
        generalColumn4.setType("string");

        generalColumnList.add(generalColumn);
        generalColumnList.add(generalColumn1);
        generalColumnList.add(generalColumn2);
        generalColumnList.add(generalColumn3);
        generalColumnList.add(generalColumn4);

        generalTable.setColumns(generalColumnList);
        generalTable.setDbType("sqlserver");
        generalTable.setName("test");
        generalTable.setPartitions(null);

        System.out.println(TableCreator.generateCreateTableSentence(generalTable));


        GeneralTable generalTable1 = new GeneralTable();
        List<GeneralColumn> generalColumnList1 = new ArrayList<GeneralColumn>();
        GeneralColumn generalColumn01 = new GeneralColumn();

        generalColumn01.setComment("a");
        generalColumn01.setIndex("0");
        generalColumn01.setName("id");
        generalColumn01.setType("varchar(20)");

        GeneralColumn generalColumn11 = new GeneralColumn();
        generalColumn11.setComment("a");
        generalColumn11.setIndex("0");
        generalColumn11.setName("id");
        generalColumn11.setType("varchar(20)");

        GeneralColumn generalColumn21 = new GeneralColumn();
        generalColumn21.setComment("a");
        generalColumn21.setIndex("0");
        generalColumn21.setName("id");
        generalColumn21.setType("varchar(20)");

        GeneralColumn generalColumn31 = new GeneralColumn();
        generalColumn31.setComment("a");
        generalColumn31.setIndex("0");
        generalColumn31.setName("id");
        generalColumn31.setType("string");

        GeneralColumn generalColumn41 = new GeneralColumn();
        generalColumn41.setComment("a");
        generalColumn41.setIndex("0");
        generalColumn41.setName("id");
        generalColumn41.setType("string");

        generalColumnList1.add(generalColumn);
        generalColumnList1.add(generalColumn1);
        generalColumnList1.add(generalColumn2);
        generalColumnList1.add(generalColumn3);
        generalColumnList1.add(generalColumn4);

        List<GeneralColumn> pars = new ArrayList<GeneralColumn>();
        GeneralColumn par = new GeneralColumn();
        par.setType("string");
        par.setName("time");
        pars.add(par);

        GeneralColumn par1 = new GeneralColumn();
        par1.setType("string");
        par1.setName("time");
        pars.add(par1);


        generalTable1.setColumns(generalColumnList1);
        generalTable1.setDbType("hive");
        generalTable1.setName("test");
        generalTable1.setPartitions(pars);

        System.out.println(TableCreator.generateCreateTableSentence(generalTable1));
    }
}
