package org.example.ranobecute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseHandler extends Configs{
    Connection dbConection;

    public Connection getDbConection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort +"/" +dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConection;
    }

    // Users Table

    public void signUpUser( User user ) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_USERNAME + "," +Const.USER_PASSWORD + "," + Const.USER_EMAIL + ")"
                + "VALUES(?,?,?)";

        try {
            PreparedStatement prSt = getDbConection().prepareStatement(insert);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());
            prSt.setString(3, user.getEmail());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "SELECT * FROM USERS WHERE username =? AND password =?";

        try {
            PreparedStatement prSt = getDbConection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    // Novels Table

    public void CreateNovel( Novel novel ){
        String insert = "INSERT INTO " + Const.NOVEL_TABLE + "(" + Const.NOVEL_TITLE + "," + Const.NOVEL_AUTHOR + "," + Const.NOVEL_GENRE +
                "," + Const.NOVEL_DESCRIPTION + "," + Const.NOVEL_STATUS + "," + Const.NOVEL_IMAGE + "," + Const.NOVEL_TYPE + "," + Const.NOVEL_YEAR + ")"
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConection().prepareStatement(insert);
            prSt.setString(1, novel.getTitle());
            prSt.setString(2, novel.getAuthor());
            prSt.setString(3, novel.getGenre());
            prSt.setString(4, novel.getDescription());
            prSt.setString(5, novel.getStatus());
            prSt.setString(6, novel.getImage());
            prSt.setString(7, novel.getType());
            prSt.setString(8, novel.getYear());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Novel> getAllNovel() throws SQLException, ClassNotFoundException {
        ArrayList<Novel> novels = new ArrayList<>();
        String insert = "SELECT * FROM " + Const.NOVEL_TABLE + " LIMIT 7";
        PreparedStatement prSt = getDbConection().prepareStatement(insert);
        ResultSet result = prSt.executeQuery();

        while( result.next() ){
            novels.add( new Novel( result.getInt("idnovels"), result.getString("title"), result.getString("author"), result.getString("genre"),
                    result.getString("description"), result.getString("status"), result.getString("image"), result.getString("type"),
                    result.getString("year"), result.getInt("chapters")));
        }

        return novels;
    }

    public Novel getNovel(String title) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;

        String select = "SELECT * FROM NOVELS WHERE title =?";

        try {
            PreparedStatement prSt = getDbConection().prepareStatement(select);
            prSt.setString(1, title);

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        resSet.next();
        return new Novel( resSet.getInt("idnovels"), resSet.getString("title"), resSet.getString("author"), resSet.getString("genre"),
                resSet.getString("description"), resSet.getString("status"), resSet.getString("image"), resSet.getString("type"),
                resSet.getString("year"), resSet.getInt("chapters"));
    }

    // Table Chapters

    public void CreateChapter( Chapter chapter ){
        String insert = "INSERT INTO " + Const.CHAPTERS_TABLE + "(" + Const.CHAPTERS_NOVEL_ID + "," + Const.CHAPTERS_VOLUME_NUMBER +
                "," + Const.CHAPTERS_CHAPTER_NUMBER + "," + Const.CHAPTERS_TITLE + "," + Const.CHAPTERS_PATH_TEXT +  ")"
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConection().prepareStatement(insert);
            prSt.setString(1, String.valueOf(chapter.getNovel_id()));
            prSt.setString(2, String.valueOf(chapter.getVolume_number()));
            prSt.setString(3, String.valueOf(chapter.getChapter_number()));
            prSt.setString(4, chapter.getTitle());
            prSt.setString(5, chapter.getPathtext());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Chapter ReadChapter(String id) throws SQLException {
        ResultSet resSet = null;

        String select = "SELECT * FROM CHAPTERS WHERE novel_id = ?";

        try {
            PreparedStatement prSt = getDbConection().prepareStatement(select);
            prSt.setString(1, id);

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        resSet.next();
        return new Chapter(resSet.getInt("novel_id"), resSet.getInt("volume_number"), resSet.getInt("chapter_number")
        , resSet.getString("title"), resSet.getString("pathtext"));
    }
}










