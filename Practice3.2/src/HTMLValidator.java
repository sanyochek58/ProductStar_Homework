public class HTMLValidator {

    static int max_size = 10;
    static int size = 0;
    static String[] stack = new String[max_size];

    static void print(){
        if(size > 0){
            System.out.println("---------");
            for (int i = size - 1; i >= 0; i--) {
                System.out.println(" | " + stack[i] + " | ");
            }
            System.out.println("---------");
        }
        else {
            if (isEmpty()){
                System.out.println("Stack is empty");
            }
            else  {
                System.out.println("Error!");
            }
        }
    }

    static void push(String tag) {
        if(size == max_size){
            throw new RuntimeException("Stack is full!");
        }
        stack[size] = tag;
        size++;
    }

    static String pop() {
        if(size == 0){
            throw new RuntimeException("Stack is empty!");
        }
        String tag = stack[size-1];
        size--;
        return tag;
    }

    static String peek() {
        if(size == 0){
            throw new RuntimeException("Stack is empty!");
        }
        return stack[size-1];
    }

    static boolean isEmpty() {
        return size == 0;
    }

    static boolean isFull() {
        return size == max_size;
    }

    // тут проверим слово на корректность закрытия тегов
    static boolean checkString(String word) {
        fillOpenTagStack(word);
        StringBuilder closeTag = new StringBuilder();
        int i = 0;
        while (i < word.length()) {
            if (word.charAt(i) == '<' && i + 1 < word.length() && word.charAt(i + 1) == '/') {
                int j = i + 2;
                while (j < word.length() && word.charAt(j) != '>') {
                    closeTag.append(word.charAt(j));
                    j++;
                }
                if (isEmpty() || !closeTag.toString().equals(peek())) {
                    return false;
                }
                pop();
                closeTag.setLength(0);
                i = j;
            }
            i++;
        }
        return isEmpty();
    }

    // Тут заполним стек открытми тегами
    private static void fillOpenTagStack(String word) {
        int i = 0;
        StringBuilder tag = new StringBuilder();
        while(i < word.length()){
            if(word.charAt(i) == '<' && word.charAt(i+1) == '/') {
                i++;
                continue;
            }
            else if (word.charAt(i) == '<') {
                int j  = i + 1;
                while(j < word.length() && word.charAt(j) != '>') {
                    tag.append(word.charAt(j));
                    j++;
                }
                push(tag.toString());
                tag.setLength(0);
            }
            i++;
        }
    }

}
