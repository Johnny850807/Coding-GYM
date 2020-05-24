
public enum GunType {

    MACHINE_GUN(new MachineGun()), SHOTGUN(new ShotGun()), SNIPER_RIFLE(new SniperRifle());

    private Gun gun;

    GunType(Gun gun) {
        this.gun = gun;
    }

    public Gun getGun() {
        return gun;
    }
}
