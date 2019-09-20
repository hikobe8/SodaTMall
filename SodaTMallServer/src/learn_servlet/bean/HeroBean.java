package learn_servlet.bean;

/**
 * Author : Ray
 * Created At : 2019-09-05 10:42 PM
 * Email : ryu18356@gmail.com
 * Description :
 */
public class HeroBean {

    public int id;
    public String name;
    public float hp;
    public int damage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
