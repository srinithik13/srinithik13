import java.sql.*;
public class ExcelConnection
{
public static void main(String[] args)
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:test");
Statement st = con.createStatement();
st.executeUpdate("Insert into [Sheet1$]"+" values ('e','f','g')");
//st.executeUpdate("delete * from [Sheet1$] where a='k'");
st.executeUpdate("update [Sheet1$] set a='aa'where a='d'");
ResultSet rs = st.executeQuery("Select * from [Sheet1$]");
ResultSetMetaData rsmd = rs.getMetaData();
int numberOfColumns = rsmd.getColumnCount();
while (rs.next())
{
for (int i = 1; i <= numberOfColumns; i++)
{
if (i > 1)
System.out.print(", ");
String columnValue = rs.getString(i);
System.out.print(columnValue);
}
System.out.println("");
}
st.close();
con.close();
} catch (Exception ex) {
System.err.print("Exception: ");
System.err.println(ex.getMessage()); }
}
}
