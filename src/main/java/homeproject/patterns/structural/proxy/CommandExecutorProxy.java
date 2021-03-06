package homeproject.patterns.structural.proxy;

/**
 * Proxy pattern provides a surrogate or placeholder for another object to control access to it.
 * The definition itself is very clear and proxy design pattern is used when we want to provide controlled access of a functionality.
 * <p>
 * Let’s say we have a class that can run some command on the system. Now if we are using it, it is fine but if we want to give this program
 * to a client application, it can have severe issues because client program can issue command to delete some system files or change some settings that you don’t want.
 */
public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user, String pwd) {
        if ("Pankaj".equals(user) && "J@urnalD$v".equals(pwd)) {
            isAdmin = true;
        }
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for non-admin users.");
            } else {
                executor.runCommand(cmd);
            }
        }
    }

}