package homeproject.patterns.structural.proxy;

public class ProxyPatternTest {

    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutorProxy("Pankaj", "J@urnalD$v");
        CommandExecutor executor2 = new CommandExecutorProxy("Pankaj", "wrong pwd");
        try {
            executor.runCommand("ls -ltr");         // will pass
            executor2.runCommand("ls -ltr");        // won't pass
            executor.runCommand(" rm -rf abc.pdf"); // won't pass
        } catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }

    }

}
