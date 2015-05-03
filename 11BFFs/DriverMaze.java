public class DriverMaze{

    public static void main(String[]args){
	Maze f;
	if(args.length < 1){
	    f = new Maze("data1.dat");
	}else{
	    f = new Maze(args[0]);
	}
	f.clearTerminal();
	int mode;
	if(args.length < 2){
	    mode = 0;
	} else {
	    mode = Integer.parseInt(args[1]);
	}
	if (mode == 0)
	    f.solveDFS(true);
	if (mode == 1)
	    f.solveBFS(true);
	
    }
    
}
