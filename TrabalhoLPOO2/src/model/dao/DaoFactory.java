package model.dao;

public class DaoFactory {
    public static DAO<?> getDao(DaoType type) {
        switch (type) {
            case CLIENTE:
                return new ClienteDaoSql();
            case VEICULO:
                return new VeiculoDaoSql();
            case LOCACAO:
                return new LocacaoDaoSql();
            default:
                throw new IllegalArgumentException("Tipo de DAO não suportado.");
        }
    }
}
