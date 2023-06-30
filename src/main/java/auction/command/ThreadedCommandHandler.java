package auction.command;

public class ThreadedCommandHandler  implements CommandHandler
{
    @Override
    public boolean handle(Command command){
        return command.doIt();
    }//handle
}//ThreadedCommandHandler
