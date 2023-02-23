package ar.com.flow.kata.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

class Chat {
    List<String> members;
    List<Integer> files;
    Map<Integer, String> message;

    public Chat() {
        this.members = new ArrayList<>();
        this.files = new ArrayList<>();
        this.message = new HashMap<>();
    }

    public void add(String[] names) {
        this.members.addAll(Arrays.stream(names).collect(Collectors.toList()));
    }

    public void add(int[] ids) {
        this.files.addAll(Arrays.stream(ids).boxed().collect(Collectors.toList()));
    }

    public void add(int id, String newMessage) {
        this.message.put(id, newMessage);
    }

    public void remove(String[] names) {
        Arrays.stream(names).forEach(name -> {
            if (this.members.contains(name)) {
                this.members.remove(name);
            } else {
                System.out.println("Member with name " + name + " does not exist");
            }
        });
    }

    public void remove(int[] ids) {
        Arrays.stream(ids).forEach(id -> {
            int indexOfValue = this.files.indexOf(id);
            if (indexOfValue >= 0) {
                this.files.remove(indexOfValue);
            } else {
                System.out.println("File with id " + id + " does not exist");
            }
        });
    }

    public void remove(int id) {
        if (this.message.containsKey(id)) {
            this.message.remove(id);
        } else {
            System.out.println("Message with id " + id + " does not exist");
        }
    }

    public void printConversation() {
        System.out.println("Total number of members in the conversation are " + this.members.size());
        System.out.println("The names of these members are " + String.join(" ", this.members));
        System.out.println("Total number of files in the conversation are " + this.files.size());
        System.out.println("The messages in the conversation are " +
                this.message.values().stream()
                        .map(message -> "'" + message + "'")
                        .collect(Collectors.joining(" ")));
    }
}
