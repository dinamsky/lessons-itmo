package lesson4;
// класс наследуется от батлюнита
public class Knight extends BattleUnit {
    public Knight(int health, int attackScore) {
        super(health, attackScore);
    }

    //переопределение метода родителя
    @Override
    public void attack(BattleUnit enemy) {
        //вызов родительского метода
        super.attack(enemy);
        // расширение функционала
        enemy.health -= 1;
    }
}
