package competition.W24608;

import java.util.LinkedList;

public class Solution2 {
    public int findWinningPlayer(int[] skills, int k) {
        if (k>=skills.length-1){
            int maxIndex = 0;
            for (int i = 0; i < skills.length; i++) {
                if (skills[maxIndex]<skills[i]){
                    maxIndex=i;
                }
            }
            return maxIndex;
        }
        LinkedList<Player> queue = new LinkedList<>();
        for (int i = 0; i < skills.length; i++) {
            queue.offerLast(new Player(i,skills[i]));
        }
        while (queue.peekFirst().num!=k){
            Player player1 = queue.get(0);
            Player player2 = queue.get(1);
            if (player1.skill>player2.skill){
                player1.num++;
                queue.remove(player2);
                queue.offerLast(player2);
            }else {
                player2.num++;
                queue.remove(player1);
                queue.offerLast(player1);
            }
        }
        return queue.peekFirst().index;
    }



    static class Player{
        int index;//下标几号
        int num;//赢得次数
        int skill;

        public Player(int index, int skill) {
            this.index = index;
            this.skill = skill;
            this.num=0;
        }
    }
}
