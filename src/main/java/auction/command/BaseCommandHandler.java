package auction.command;

public class BaseCommandHandler implements CommandHandler
{
    @Override
    public boolean handle(Command command){
        return command.doIt();
    }//handle
}//BaseCommandHandler
