package y2020.m10.d24;

import java.util.Scanner;

class Main_NHN_1 {
  private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
	  StringBuilder sb = new StringBuilder();
	  int[] answer = new int[numOfAllPlayers];
	  answer[0]=1;
	  int N = numOfAllPlayers-1;
	  boolean[] fast = new boolean[numOfAllPlayers];
	  for(int i=0;i<namesOfQuickPlayers.length;i++) {
		  fast[(int)(namesOfQuickPlayers[i]-'A')]=true;
	  }
	  char[] seat = new char[N];
	  char tar = 'A';
	  int index = 0;
	  for(int i=0;i<N;i++) {
		  seat[i]=(char)('B'+i);
	  }
	  for(int i=0;i<numOfGames;i++) {
		  index = (index+numOfMovesPerGame[i]+N)%N;
		  
		  if(fast[seat[index]-'A']) {
			  answer[tar-'A']++;
		  }else {
			  char temp = tar;
			  tar = seat[index];
			  seat[index]=temp;
			  answer[tar-'A']++;
		  }
	  }
	  for(int i=0;i<N;i++) {
		  sb.append(seat[i]).append(" ").append(answer[seat[i]-'A']).append("\n");
	  }
	  sb.append(tar).append(" ").append(answer[tar-'A']).append("\n");
	  System.out.println(sb.toString());
  }

private static class InputData {
    int numOfAllPlayers;
    int numOfQuickPlayers;
    char[] namesOfQuickPlayers;
    int numOfGames;
    int[] numOfMovesPerGame;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
      for(int i = 0; i < inputData.numOfGames ; i++){
        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
  }
}