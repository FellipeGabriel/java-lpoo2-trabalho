/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import interfaces.ClienteI;
import java.util.Arrays;
/**
 *
 * @author janai
 */
public class ClienteC implements ClienteI{
    private static ClienteC[] clientes;
    private String name;
    private String sobreNome;
    private String RG;
    private String CPF;
    private String endereco;
    
    public ClienteC(String name,String sobreNome, String RG,String CPF, String endereco){
        this.name=name;
        this.sobreNome=sobreNome;
        this.RG=RG;
        this.CPF=CPF;
        this.endereco=endereco;
        CreateCliente();
    }
    public static ClienteC[] getClientes() {
        return clientes;
    }
    @Override
    public  void CreateCliente(){
        if (clientes == null) {
            clientes = new ClienteC[1];
            clientes[0] = this;
        } else {
            ClienteC[] N_clientes = Arrays.copyOf(clientes, clientes.length + 1);
            N_clientes[clientes.length] = this;
            clientes = N_clientes;
        }
        
    };
    @Override
    public void ChangeCliente(String name,String sobrenome,String RG,String CPF,String endereco){
        this.name=name;
        this.sobreNome=sobrenome;
        this.RG=RG;
        this.CPF=CPF;
        this.endereco=endereco;
    };
    @Override
    public void DeleteCliente(){
        if (clientes != null) {
            int index = -1;
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] == this) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                ClienteC[] newClientes = new ClienteC[clientes.length - 1];
                System.arraycopy(clientes, 0, newClientes, 0, index);
                System.arraycopy(clientes, index + 1, newClientes, index, clientes.length - index - 1);
                clientes = newClientes;
            }
        }
    };
    
    public String getName(){
        return this.name;
    }
    
    public String getSobrenome(){
        return this.sobreNome;
    }
    
    public String getRG(){
        return this.RG;
    }
    
    public String getCPF(){
        return this.CPF;
    }
    
    public String getEndereco(){
        return this.endereco;
    }
    public static ClienteC getCliente(int index){
        return clientes[index];
    }
    
    public static ClienteC[] getAllClientes() {
        return clientes;
    }
}
