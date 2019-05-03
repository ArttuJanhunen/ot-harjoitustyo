package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.muistipeli.dao.PlayerDao;
import com.mycompany.muistipeli.logics.Player;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajanhune
 */
public class PlayerDaoTest {

    PlayerDao dao;
    ArrayList<Player> scoreList;

    @Before
    public void setUp() {
        dao = new PlayerDao();
        scoreList = new ArrayList();
    }

    @Test
    public void playerDaoCreatesNewFileIfItDoesntExist() throws IOException {
        assertEquals(false, new File("textlist.txt").exists());

        dao.getHighscores(scoreList, "textlist.txt");

        assertEquals(true, new File("textlist.txt").exists());

        new File("textlist.txt").delete();

        assertEquals(false, new File("textfile.txt").exists());
    }

    @Test
    public void playerDaoSavesDataAndRetrievesIt() throws IOException {
        String path = new File("testlist.txt").getAbsolutePath();
        File testfile = new File(path);
        scoreList.add(new Player("Test", 120));
        dao.saveHighScores(scoreList, "testlist.txt");

        ArrayList<Player> anotherList = new ArrayList<>();

        dao.getHighscores(anotherList, "testlist.txt");

        assertEquals(1, anotherList.size());
        
        testfile.delete();
        
        
    }

}
