package ar.com.flow.kata.hackerrank;

import org.assertj.core.util.Lists;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChatTest {
    @Test
    public void addNames() {
        Chat chat = new Chat();
        String[] names = new String[]{"John", "Ray", "Zee"};
        chat.add(names);

        assertThat(chat.members).hasSameElementsAs(Lists.newArrayList("John", "Ray", "Zee"));
    }

    @Test
    public void addFiles() {
        Chat chat = new Chat();
        int[] files = new int[]{567, 986, 789};
        chat.add(files);

        assertThat(chat.files).hasSameElementsAs(Lists.newArrayList(567, 986, 789));
    }

    @Test
    public void addMessage() {
        Chat chat = new Chat();
        int id = 1;
        String message = "Hey there";
        chat.add(id, message);
        assertThat(chat.message.get(id)).isEqualTo(message);
    }

    @Test
    public void removeAllExistingNames() {
        Chat chat = new Chat();
        String[] names = new String[]{"John", "Ray", "Zee"};
        chat.add(names);
        chat.remove(names);

        assertThat(chat.members).isEmpty();
    }

    @Test
    public void removeAllExistingFiles() {
        Chat chat = new Chat();
        int[] files = new int[]{567, 986, 789};
        chat.add(files);
        chat.remove(files);

        assertThat(chat.files).isEmpty();
    }
}
