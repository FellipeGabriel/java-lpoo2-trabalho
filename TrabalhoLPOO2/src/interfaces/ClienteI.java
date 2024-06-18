/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author janai
 */
public interface ClienteI {
    public void CreateCliente();
    public void ChangeCliente(String name,String sobrenome,String RG,String CPF,String endereco);
    public void DeleteCliente();
}
