package db61b;

import org.junit.Test;
import ucb.junit.textui;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/** The suite of all JUnit tests for the qirkat package.
 *  @author P. N. Hilfinger
 */
public class UnitTest {

    /** Run the JUnit tests in this package. Add xxxTest.class entries to
     *  the arguments of runClasses to run other JUnit tests. */
    public static void main(String[] ignored) {
        /* textui.runClasses(); */

    }

    @Test
    public void testTable() {
        Table a = new Table(new String[] {"SID", "Lastname", "Firstname",
                "SemEnter", "YearEnter", "Major"});
        String[] _student1 = new String[] {"101", "Knowles", "Jason",
                "F", "2003", "EECS"};
        String[] _student2 = new String[] {"102", "Chan", "Valerie",
                "S", "2003", "Math"};
        a.add(_student1);
        a.add(_student2);
        assertEquals(false, a.add(_student1));
    }

    @Test
    public void testTable2() {
        Table a = new Table(new String[] {"SID", "Firstname", "Major"});
        String[] _student1 = new String[] {"101", "Knowles", "Jason",
                "F", "2003", "EECS"};
        String[] _student2 = new String[] {"101", "Chan", "Valerie",
                "S", "2003", "Math"};
        a.add(_student1);
        a.add(_student2);
        assertEquals(false, a.add(_student1));
    }

    @Test
    public void testSelectTable() {
        Table a = new Table(new String[] {"SID", "Lastname", "Firstname",
                "SemEnter", "YearEnter", "Major"});
        String[] _student1 = new String[] {"101", "Knowles", "Jason",
                "F", "2003", "EECS"};
        String[] _student2 = new String[] {"102", "Chan", "Valerie",
                "S", "2003", "Math"};
        a.add(_student1);
        a.add(_student2);
        List<String> columnsNames = new ArrayList<String>();
        columnsNames.add("SID");
        columnsNames.add("Firstname");
        columnsNames.add("Major");
        List<Condition> conditions = new ArrayList<Condition>();
        conditions.add(new Condition(new Column("SID", a), "=", "101"));
        Table newa = a.select(columnsNames, conditions);
        Table b = new Table(new String[] {"SID", "Firstname", "Major"});
        String[] _student1_1 = new String[] {"101", "Jason", "EECS"};
        b.add(_student1_1);

    }


}
