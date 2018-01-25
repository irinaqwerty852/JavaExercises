/**
 * JBasic - the simplest BASIC on Java
 *
 * @author Sergey Iryupin
 * @version 0.2 dated Jan 25, 2018
 */
import java.util.Scanner;

class JBasic implements IConstants {
    ProgramLines programLines;
    Variables variables;
    Interpreter interpreter;

    public static void main(String[] args) {
        new JBasic();
    }

    JBasic() {
        variables = new Variables();
        programLines = new ProgramLines();
        interpreter = new Interpreter(programLines, variables);
        Scanner scr = new Scanner(System.in);
        String str;
        do {
            System.out.print("> ");
            str = scr.nextLine();
            switch (Tools.getPieceOfString(str)) {
                case CMD_NEW:
                    programLines.deleteAll();
                    break;
                case CMD_LIST:
                    programLines.list();
                    break;
                case CMD_DELETE:
                    programLines.delete(str);
                    break;
                case CMD_SAVE:
                    programLines.save(str);
                    break;
                case CMD_LOAD:
                    programLines.load(str);
                    break;
                case CMD_RUN:
                    interpreter.run();
                    break;
                case CMD_EXIT:
                    break;
                default:
                    if (Tools.getLineNumber(str) > 0)
                        programLines.add(str);
            }
        } while (!str.equals(CMD_EXIT));
    }
}