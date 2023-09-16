// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.*;
import java.util.Date;
import java.io.File;

public class MysqlJdbc {

    /**
     * 链接数据库
     * @param database 具体的数据库
     * @return
     * @throws Exception
     */
    private static Connection get_connection(String database) throws Exception {
        String url = "jdbc:mysql://124.70.10.79:3307";
        if(database!=null){
            url=url+"/"+database;
        }

        String username = "root";
        String password = "root";
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);

        return DriverManager.getConnection(url, username, password);

    }

    /**
     * 查找具体表的所有（字段名字），（主键），（主键类型），索引信息
     * @param con
     * @param databasename
     * @param record
     * @return
     * @throws Exception
     */
    public static List<String> getTableFields(Connection con,String databasename,String record) throws Exception {


        //存放当前表的字段
        List<String> fields = new ArrayList<>();
            String sql = "select * from " + record;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rstable = ps.executeQuery();
            //结果集元数据
            ResultSetMetaData meta = rstable.getMetaData();
            //表列数量
            int columeCount = meta.getColumnCount();
            String allziduan=new String();
            for (int i = 1; i <= columeCount; i++) {
                allziduan=allziduan+meta.getColumnName(i)+"; ";

            }
            System.out.println(allziduan);
            fields.add(allziduan);
        //查询主键
         sql = "SELECT COLUMN_NAME, EXTRA FROM information_schema.COLUMNS WHERE (TABLE_SCHEMA = '"+databasename+"') " +
                 "AND (TABLE_NAME = '"+record+"') " +
                 "AND (COLUMN_KEY = 'PRI');";
        System.out.println(sql);
         ps = con.prepareStatement(sql);

        rstable = ps.executeQuery();
        //结果集元数据
         meta = rstable.getMetaData();
         //1主键 2主键类型
         if(rstable.next()){
             fields.add((String)rstable.getObject(1));
             fields.add((String)rstable.getObject(2));
         }
         else{

             fields.add(" ");
         }

         //索引
        sql = "show index from "+databasename+"."+record;
        System.out.println(sql);
        ps = con.prepareStatement(sql);

        rstable = ps.executeQuery();
        //结果集元数据
        meta = rstable.getMetaData();
        //索引可能有好几个
        int f=0;
        String index=new String();
        while (rstable.next()){
            f=1;
            String key_name=rstable.getString("Key_name");

            String Column_name=rstable.getString("Column_name");
            String nullable= rstable.getString("Null");
            if(!"YES".equals(nullable)){
                nullable="NO";
            }
            index=index+key_name+";"+Column_name+";"+nullable+". ";

        }
        if(f==1){
            System.out.println(index);
            fields.add(index);
        }
        {
                fields.add(" ");
        }



        return fields;
    }


    /**
     * 写入csv文件
     * @param database_name
     * @param table_name
     * @param fileds
     * @throws Exception
     */
    public static  void writetxt(String database_name,String table_name,List<String> fileds) throws Exception {

        File file =new File("C:\\Users\\nsf\\Desktop\\database.csv");
        RandomAccessFile raf=new RandomAccessFile(file,"rw");
        raf.seek(0);
        raf.write("database_name,table_name,fileds_names,pri_key,pri_key_type,index(Key_name;Column_name;Nullable)".getBytes());
        raf.write("\n".getBytes());


        String guding=database_name+","+table_name+",";
        StringBuffer row=new StringBuffer(guding);
        for (int i = 0; i < fileds.size(); i++) {
            row.append(fileds.get(i) +",");

        }
        // 文件长度，字节数
        long fileLength = raf.length();
        // 将写文件指针移到文件尾。
        raf.seek(fileLength);
        raf.seek(raf.length());
        raf.write(row.toString().getBytes());
        raf.write("\n".getBytes());
    }

    public static void main(String args[]) {

        try {
            Connection conn = get_connection(null);
            //获取数据库的元数据
            DatabaseMetaData dbMetaData = conn.getMetaData();
            //从元数据中获取到所有的表名
            ResultSet rs = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
            //存放所有表名
            List<String> tableNames = new ArrayList<>();
            //存放数据库所存在的表名
            Map<String ,List<String>> databasemap = new HashMap<>();


            while (rs.next()) {
                System.out.println("表名: " + rs.getString("TABLE_NAME"));
                System.out.println("表类型: " + rs.getString("TABLE_TYPE"));
                System.out.println("表所属数据库: " + rs.getString("TABLE_CAT"));
                System.out.println("表所属用户名: " + rs.getString("TABLE_SCHEM"));
                System.out.println("表备注: " + rs.getString("REMARKS"));
                tableNames.add(rs.getString("TABLE_NAME"));
                List<String> tmp=tmp=new ArrayList<>();;
                if(databasemap.containsKey(rs.getString("TABLE_CAT"))){
                    tmp=databasemap.get(rs.getString("TABLE_CAT"));
                }
                tmp.add(rs.getString("TABLE_NAME"));
                databasemap.put(rs.getString("TABLE_CAT"), tmp);
            }
            conn.close();


            //便利数据库
            for (Map.Entry<String, List<String>> entry : databasemap.entrySet()) {

                String databasename = entry.getKey();
                Connection conn2 = get_connection(databasename);
                List<String> tablesname = entry.getValue();
                for (int i = 0; i < tablesname.size(); i++) {
                    writetxt(databasename,tablesname.get(i),getTableFields(conn2,databasename, tablesname.get(i)));
                }
            }

        } catch (Exception e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
    }
}