package assignment10;

import java.util.Scanner;

public class Main {
    private static Tile[][] tiles = new Tile[6][6];

    public static void main(String[] args) {
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                tiles[i][j] = new Tile();
            }
        }
        for(int i = 0; i < 12; i++){
            int randX = (int)(Math.random()*6);
            int randY = (int)(Math.random()*6);
            tiles[randX][randY] = new Treasure();
        }
        Scanner scan = new Scanner(System.in);

        dig(10);
        System.out.print("Oh no! The digging site collapsed");
        String[] ellipsis = {".",".","."};
        for(String s : ellipsis){
            try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}    
            System.out.print(s);
        }
        System.out.println("\n\n\n\n\n\n\n");
        
        Treasure.getBag();
    }

    public static void dig(int atmp){
        if(atmp<=0){
            return;
        }
        pickATile();



        dig(atmp-1);
    }

    public static void pickATile(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Where would you like to dig? ⛏");
        printTiles();
        int x = 0;
        int y = 0;
        System.out.print("\n > X: ");
        x = scan.nextInt() - 1;
        System.out.print("\n > Y: ");
        y = scan.nextInt() - 1;
        if(x>=0&&x<=5){
            if(y>=0&&y<=5){
                if(tiles[y][x].getDug()){
                    System.out.println("\nYou already dug in that spot!\n");
                    pickATile();
                    return;
                }
                digAt(x,y);
                return;
            }
        }
        System.out.println("\nInvalid coordinates!\n");
        pickATile();
        
    }

    public static void printTiles(){
        for(Tile[] t : tiles){
            for(Tile tile : t){
                System.out.print(tile + "  ");
            }
            System.out.println();
        }
    }

    public static void digAt(int x, int y){
        tiles[y][x].digUp();
    }

}
