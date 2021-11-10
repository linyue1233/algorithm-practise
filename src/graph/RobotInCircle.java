package graph;

public class RobotInCircle {
    // 1041
    public boolean isRobotBounded(String instructions) {
        int len = instructions.length();
        int x = 0, y = 0;
        int initVector = 0;
        for(int i = 0;i<len;++i){
            if(instructions.charAt(i) == 'L'){
                initVector -= 90;
            }else if(instructions.charAt(i) == 'R'){
                initVector += 90;
            }else{
                int tan = Math.abs(initVector % 360);
                if( tan == 0){
                    y += 1;
                }else if(tan == 90){
                    x += 1;
                }else if( tan == 180){
                    y -= 1;
                }else{
                    x -= 1;
                }
            }
        }
        initVector = Math.abs(initVector%360);
        return initVector != 0 || (x == 0 && y == 0);
    }
}
