package test.tonatumi.timerpluginatjava;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public  class TimerPluginAtJava extends JavaPlugin {

    int time = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        //コマンド打ったのがプレイヤーではないとき
        if (!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;

        if (args.length == 0) {
            showHelp(p);
            return true;
        }

        if (args.length == 1) {
            //start
            if (args[0].equalsIgnoreCase("start")) {
                //runnableのやつ
                start();
                return true;
            }

            //stop
            if (args[0].equalsIgnoreCase("stop")) {
                //止めるやつ
                return true;
            }

            //delete
            if (args[0].equalsIgnoreCase("delete")) {
                //タイマー消す
                time = 0;
                return true;
            }
            return true;
        }

        if (args.length == 3) {
            //set
            if (args[0].equalsIgnoreCase("set")) {
                try {
                    Integer.parseInt(args[1]);
                    Integer.parseInt(args[2]);
                    return true;
                } catch (NumberFormatException e) {
                    p.sendMessage("数字でいれてください");
                    return true;
                }
                if (!(Integer.parseInt(args[2]) <= 59)) {
                    p.sendMessage("秒は59秒以内で");
                    return true;

                }

                return true;
            }

        }

        p.sendMessage("wrong command");
        return true;
    }


    String prefix = "§y[TimerPluginAtJava]";

    //help
    public void showHelp(Player p) {
        p.sendMessage("How to use " + prefix);
        p.sendMessage("/timer set [分] [秒] : ");
        p.sendMessage("/timer start : ");
        p.sendMessage("/timer stop : ");
        p.sendMessage("/timer delete : ");
    }

    //timer set


    //timer start
    public void start() {
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimer(this, 0, 20);
    }


    @Override
    public void onEnable() {
        getCommand("timer").setExecutor(this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
