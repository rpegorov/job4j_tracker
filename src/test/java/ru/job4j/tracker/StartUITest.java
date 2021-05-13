package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * <p>StartUITest class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class StartUITest {

    /**
     * <p>whenCreateNewItem.</p>
     */
    @Test
    public void whenCreateNewItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    /**
     * <p>whenReplaceItem.</p>
     */
    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", "1", "New item name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    /**
     * <p>deleteItem.</p>
     */
    @Test
    public void deleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    /**
     * <p>showAll.</p>
     */
    @Test
    public void showAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item test"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu."
                + System.lineSeparator() + "=== Show all item ==="
                + System.lineSeparator() + "Item ID: 1 |  Name: Item test"
                + System.lineSeparator() + "Menu."
                + System.lineSeparator() + "=== Exit program ==="
                + System.lineSeparator() + "Exit program, good bay!" + System.lineSeparator())
        );
    }

    /**
     * <p>findByNameAction.</p>
     */
    @Test
    public void findByNameAction() {
        StubOutput out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(
                new String[]{"0", "Item", "1"}
        );
        UserAction[] actions = {
                new FindNameAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu."
                + System.lineSeparator() + "=== Find items by name ==="
                + System.lineSeparator() + "Find ID is: 1"
                + System.lineSeparator() + "Menu."
                + System.lineSeparator() + "=== Exit program ==="
                + System.lineSeparator() + "Exit program, good bay!" + System.lineSeparator())
        );
    }

    /**
     * <p>findByIDAction.</p>
     */
    @Test
    public void findByIDAction() {
        StubOutput out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindIdAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu."
                + System.lineSeparator() + "=== Find item by ID ==="
                + System.lineSeparator() + "Find item is: Item"
                + System.lineSeparator() + "Menu."
                + System.lineSeparator() + "=== Exit program ==="
                + System.lineSeparator() + "Exit program, good bay!" + System.lineSeparator())
        );
    }

    /**
     * <p>whenExit.</p>
     */
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu."
                + "\n=== Exit program ==="
                + "\nExit program, good bay!"
                + "\n"));
    }

    /**
     * <p>whenInvalid.</p>
     */
    @Test
    public void whenInvalid() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"7", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu."
                + System.lineSeparator() + "Wrong input, you can select: 0 - 0"
                + System.lineSeparator() + "Menu."
                + System.lineSeparator() + "=== Exit program ==="
                + System.lineSeparator() + "Exit program, good bay!"
                + System.lineSeparator())
        );
    }

    /**
     * <p>whenInvalidInput.</p>
     */
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(), is("Uncorrected data. "
                + "Please enter validate data again."
                + System.lineSeparator()));
    }

    /**
     * <p>whenInvalidInput2.</p>
     */
    @Test
    public void whenInvalidInput2() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
}
