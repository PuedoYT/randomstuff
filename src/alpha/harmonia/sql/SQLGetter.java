package alpha.harmonia.sql;

import alpha.harmonia.Main;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SQLGetter {

    private Main plugin;
    public SQLGetter(Main plugin) {
        this.plugin = plugin;
    }

    public void createTable(){
        PreparedStatement ps;
        try{
            //0 == Faux
            //1 == Vrai
            ps = plugin.SQL.getConnection().prepareStatement(
                    "CREATE TABLE IF NOT EXISTS moderation " +
                    "(NAME VARCHAR(100),UUID VARCHAR(100),CANCHAT BOOLEAN(1),BANNED BOOLEAN(0),PRIMARY KEY (NAME))");
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void createPlayer(Player player){
        try{
            UUID uuid = player.getUniqueId();
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM moderation WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet results = ps.executeQuery();
            results.next();
            if(!exists(uuid)){
                PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement(
                        "INSERT IGNORE INFO harmonia (NAME, UUID) VALUES(?,?)");
                ps2.setString(1, player.getName());
                ps2.setString(2, uuid.toString());
                ps2.executeUpdate();
                return;
            }
        }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public boolean exists(UUID uuid){
        try{
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM moderation WHERE UUID=?");
            ps.setString(1, uuid.toString());

            ResultSet results = ps.executeQuery();
            if(results.next()) {
                return true;
            }
        }
        catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public void setChatPerm(UUID uuid, boolean canchat){
        try{
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE moderation SET CANCHAT=? WHERE UUID=?");
            ps.setBoolean(1, (getChatPerm(uuid) == canchat));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        }
        catch(SQLException e){e.printStackTrace();}
    }

    public boolean getChatPerm(UUID uuid){
        try{
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT CANCHAT FROM moderation WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            boolean canChat = true;
            if(rs.next()){
                canChat = rs.getBoolean("CANCHAT");
                return canChat;
            }
        }
        catch(SQLException e){e.printStackTrace();}
        return false;
    }

}
