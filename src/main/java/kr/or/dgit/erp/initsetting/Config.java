package kr.or.dgit.erp.initsetting;

public class Config {
	public static final String DB_NAME = "erp";
	public static final String USER   = "root";
	public static final String PWD    = "rootroot";
	public static final String URL    = "jdbc:mysql://localhost:3306/";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public static final String[] TABLE_NAME = {"title","department","employee"};
	
	public static final String[] CREATE_SQL_TABLE={
			//직급
			"CREATE TABLE if not exists title "
			+ "(	title_no    CHAR(5)     not NULL,	"
			+ "title_name  VARCHAR(20) not null,	"
			+ "isexist boolean not null,	"
			+ "PRIMARY KEY (title_no))" ,
			
			//부서
			"CREATE TABLE if not exists department (	"
			+ "dept_no    CHAR(5)     not NULL,	"
			+ "dept_name  VARCHAR(20) not null,	"
			+ "floor integer,	"
			+ "isexist boolean not null,	"
			+ "PRIMARY KEY (dept_no));",
			
			//사원
			
			"CREATE TABLE if not exists employee (	"
			+ "emp_no     CHAR(5)     not NULL, "
			+ "emp_name   VARCHAR(20) not null,	"
			+ "title  CHAR(5) not null,	"
			+ "salary integer ,	"
			+ "gender boolean     "
			+ "not null,	"
			+ "hobbys varchar(20),	"
			+ "department CHAR(5),	"
			+ "joinDate Date,	"
			+ "isexist boolean not null,	"
			+ "PRIMARY KEY (emp_no),	"
			+ "FOREIGN KEY (title) REFERENCES title(title_no),	"
			+ "FOREIGN KEY (department) REFERENCES department(dept_no))  "		
			
			
	};
	
						
	public static final String EXPORT_IMPORT_DIR = System.getProperty("user.dir")+ "\\BackupFiles\\";
	
	
}
