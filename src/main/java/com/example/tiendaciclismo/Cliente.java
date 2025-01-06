/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tiendaciclismo;

/**
 *
 * @author jorge
 */

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente {
    private static long contador = 0; // Contador estático para generar códigos únicos

    private long codigo;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String correo;
    private String provincia;
    private String canton;
    private String distrito;
    private LocalDate fechaNacimiento;

    // Lista de provincias, sus cantones y los respectvos distritos
    public static final Map<String, Map<String, List<String>>> PROVINCIAS_CANTONES_DISTRITOS = new HashMap<>();

    static {
        Map<String, List<String>> sanJose = new HashMap<>();
        sanJose.put("Central", List.of("Carmen", "Merced", "Hospital", "Catedral", "Zapote", "San Francisco de Dos Ríos", "Uruca", "Mata Redonda", "Pavas"));
        sanJose.put("Escazú", List.of("Escazú Centro", "San Rafael", "San Antonio"));
        sanJose.put("Desamparados", List.of("Desamparados Centro", "San Miguel", "San Juan de Dios", "San Rafael Arriba", "San Rafael Abajo", "Gravilias", "Damas"));
        sanJose.put("Puriscal", List.of("Santiago", "Mercedes Sur", "Barbacoas", "Grifo Alto", "San Rafael", "Candelarita", "Desamparaditos", "San Antonio", "Chires"));
        sanJose.put("Tarrazú", List.of("San Marcos", "San Lorenzo", "San Carlos"));
        sanJose.put("Aserrí", List.of("Aserrí Centro", "Tarbaca", "Vuelta de Jorco", "San Gabriel", "Legua", "Monterrey", "Salitrillos"));
        sanJose.put("Mora", List.of("Colón", "Guayabo", "Tabarcia", "Piedras Negras", "Picagres"));
        sanJose.put("Goicoechea", List.of("Guadalupe", "San Francisco", "Calle Blancos", "Mata de Plátano", "Ipís", "Rancho Redondo", "Purral"));
        sanJose.put("Santa Ana", List.of("Santa Ana Centro", "Salitral", "Pozos", "Uruca", "Piedades", "Brasil"));
        sanJose.put("Alajuelita", List.of("Alajuelita Centro", "San Josecito", "San Antonio", "Concepción", "San Felipe"));
        sanJose.put("Vásquez de Coronado", List.of("San Isidro", "San Rafael", "Dulce Nombre de Jesús", "Patalillo", "Cascajal"));
        sanJose.put("Acosta", List.of("San Ignacio", "Guaitil", "Palmichal", "Cangrejal", "Sabanillas"));
        sanJose.put("Tibás", List.of("San Juan", "Cinco Esquinas", "Anselmo Llorente", "León XIII", "Colima"));
        sanJose.put("Moravia", List.of("San Vicente", "San Jerónimo", "La Trinidad"));
        sanJose.put("Montes de Oca", List.of("San Pedro", "Sabanilla", "Mercedes", "San Rafael"));
        sanJose.put("Turrubares", List.of("San Pablo", "San Pedro", "San Juan de Mata", "San Luis", "Carara"));
        sanJose.put("Dota", List.of("Santa María", "Jardín", "Copey"));
        sanJose.put("Curridabat", List.of("Curridabat Centro", "Granadilla", "Sánchez", "Tirrases"));
        sanJose.put("Pérez Zeledón", List.of("San Isidro de El General", "El General", "Daniel Flores", "Rivas", "San Pedro", "Platanares", "Pejibaye", "Cajón", "Barú", "Río Nuevo", "Páramo"));
        sanJose.put("León Cortés", List.of("San Pablo", "San Andrés", "Llano Bonito", "San Isidro", "Santa Cruz", "San Antonio"));

        PROVINCIAS_CANTONES_DISTRITOS.put("San José", sanJose);

        Map<String, List<String>> alajuela = new HashMap<>();
        alajuela.put("Central", List.of("Alajuela Centro", "San José", "Carrizal", "San Antonio", "Guácima", "San Isidro", "Sabanilla", "Tambor", "Garita", "Sarapiquí"));
        alajuela.put("San Ramón", List.of("San Ramón Centro", "Santiago", "San Juan", "Piedades Norte", "Piedades Sur", "San Rafael", "San Isidro", "Angeles", "Alfaro", "Volio", "Concepción", "Zapotal", "Peñas Blancas"));
        alajuela.put("Grecia", List.of("Grecia Centro", "San Isidro", "San José", "San Roque", "Tacares", "Puente de Piedra", "Bolívar"));
        alajuela.put("San Mateo", List.of("San Mateo Centro", "Desmonte", "Jesús María", "Labrador"));
        alajuela.put("Atenas", List.of("Atenas Centro", "Jesús", "Mercedes", "San Isidro", "Concepción", "San José", "Santa Eulalia", "Escobal"));
        alajuela.put("Naranjo", List.of("Naranjo Centro", "San Miguel", "San José", "Cirrí Sur", "San Jerónimo", "San Juan", "El Rosario", "Palmitos"));
        alajuela.put("Palmares", List.of("Palmares Centro", "Zaragoza", "Buenos Aires", "Santiago", "Candelaria", "Esquipulas", "La Granja"));
        alajuela.put("Poás", List.of("San Pedro", "San Juan", "San Rafael", "Carrillos", "Sabana Redonda"));
        alajuela.put("Orotina", List.of("Orotina Centro", "Mastate", "Hacienda Vieja", "Coyolar", "La Ceiba"));
        alajuela.put("San Carlos", List.of("Quesada", "Florencia", "Buenavista", "Aguas Zarcas", "Venecia", "Pital", "Fortuna", "Tigra", "Palmera", "Venado", "Cutris", "Monterrey", "Pocosol"));
        alajuela.put("Zarcero", List.of("Zarcero Centro", "Laguna", "Tapezco", "Guadalupe", "Palmira", "Zapote", "Brisas"));
        alajuela.put("Valverde Vega", List.of("Sarchí Norte", "Sarchí Sur", "Toro Amarillo", "San Pedro", "Rodríguez"));
        alajuela.put("Upala", List.of("Upala Centro", "Aguas Claras", "San José", "Bijagua", "Delicias", "Dos Ríos", "Yolillal", "Canalete"));
        alajuela.put("Los Chiles", List.of("Los Chiles Centro", "Caño Negro", "El Amparo", "San Jorge"));
        alajuela.put("Guatuso", List.of("San Rafael", "Buenavista", "Cote"));
        alajuela.put("Río Cuarto", List.of("Río Cuarto Centro", "Santa Rita", "Santa Isabel"));

        PROVINCIAS_CANTONES_DISTRITOS.put("Alajuela", alajuela);

        Map<String, List<String>> cartago = new HashMap<>();
        cartago.put("Central", List.of("Oriental", "Occidental", "Carmen", "San Nicolás", "Aguacaliente", "Guadalupe", "Corralillo", "Tierra Blanca", "Dulce Nombre", "Llano Grande", "Quebradilla"));
        cartago.put("Paraíso", List.of("Paraíso Centro", "Santiago", "Orosi", "Cachí", "Llanos de Santa Lucía"));
        cartago.put("La Unión", List.of("Tres Ríos", "San Diego", "San Juan", "San Rafael", "Concepción", "Dulce Nombre", "San Ramón", "Río Azul"));
        cartago.put("Jiménez", List.of("Juan Viñas", "Tucurrique", "Pejibaye"));
        cartago.put("Turrialba", List.of("Turrialba Centro", "La Suiza", "Peralta", "Santa Cruz", "Santa Teresita", "Pavones", "Tuis", "Tayutic", "Santa Rosa", "Tres Equis", "La Isabel", "Chirripó"));
        cartago.put("Alvarado", List.of("Pacayas", "Cervantes", "Capellades"));
        cartago.put("Oreamuno", List.of("San Rafael", "Cot", "Potrero Cerrado", "Cipreses", "Santa Rosa"));
        cartago.put("El Guarco", List.of("El Tejar", "San Isidro", "Tobosi", "Patio de Agua"));

        PROVINCIAS_CANTONES_DISTRITOS.put("Cartago", cartago);

        Map<String, List<String>> heredia = new HashMap<>();
        heredia.put("Central", List.of("Heredia Centro", "Mercedes", "San Francisco", "San Joaquín", "Vara Blanca", "Santo Domingo", "Barva", "San Rafael", "San Isidro"));
        heredia.put("San Rafael", List.of("San Rafael Centro", "Santa Rosa", "San José de la Montaña", "La Montaña", "Santa Elena"));
        heredia.put("Belén", List.of("Belén Centro", "San Antonio", "La Ribera", "San José", "Concepción"));
        heredia.put("Flores", List.of("San Joaquín", "La Virgen", "Barrantes", "Las Juntas", "San Pablo"));
        heredia.put("San Isidro", List.of("San Isidro de Heredia", "Santa Lucía", "San Antonio", "La Ceiba", "San Juan"));
        heredia.put("Santa Bárbara", List.of("Santa Bárbara Centro", "San Pedro", "San Juan", "La Lucha", "San José", "San Luis"));
        heredia.put("San Rafael", List.of("San Rafael de Heredia", "San Vicente", "Barbilla", "San Sebastián", "Vara Blanca"));

        PROVINCIAS_CANTONES_DISTRITOS.put("Heredia", heredia);
        
        Map<String, List<String>> guanacaste = new HashMap<>();
        guanacaste.put("Liberia", List.of("Liberia Centro", "Cañas", "Curubandé", "San Vicente", "Nacascolo"));
        guanacaste.put("Nicoya", List.of("Nicoya Centro", "San Antonio", "Sámara", "Nandayure", "Carmona"));
        guanacaste.put("Santa Cruz", List.of("Santa Cruz Centro", "Diriá", "Belen", "Caña", "Veintisiete de Abril"));
        guanacaste.put("Carrillo", List.of("Filadelfia", "San Rafael", "Boca de los Ríos", "Santa María", "El Coco"));
        guanacaste.put("Hojancha", List.of("Hojancha Centro", "Puente de Piedra", "La Grecia", "Cañas"));
        guanacaste.put("Tilarán", List.of("Tilarán Centro", "San Isidro", "Quebrada Grande", "El Triunfo", "Lagarto"));
        guanacaste.put("Bagaces", List.of("Bagaces Centro", "La Libertad", "Puente de Abajo", "Cañas Dulces"));

        PROVINCIAS_CANTONES_DISTRITOS.put("Guanacaste", guanacaste);

        Map<String, List<String>> puntarenas = new HashMap<>();
        puntarenas.put("Puntarenas", List.of("Puntarenas Centro", "Barranca", "Chacarita", "La Isla", "Puntarenas de Tajo", "Paquera"));
        puntarenas.put("Esparza", List.of("Esparza Centro", "Macacona", "Bajo de los Pozos", "San Juan de Caña", "San Isidro"));
        puntarenas.put("Buenos Aires", List.of("Buenos Aires Centro", "Volcán", "Chacarita", "Río Claro", "Bajo Cedral"));
        puntarenas.put("Golfito", List.of("Golfito Centro", "Puerto Jiménez", "Pavones", "Rivas", "Zancudo"));
        puntarenas.put("Coto Brus", List.of("Coto Brus Centro", "San Vito", "Limoncito", "Río Claro", "Finca 42"));
        puntarenas.put("Osa", List.of("Palmar Sur", "Palmar Norte", "Ciudad Cortés", "Agujitas", "Rivas", "Bahía Drake"));
        puntarenas.put("Corredores", List.of("Corredores Centro", "La Cuesta", "La Lucha", "San Vito", "Gavilanes"));

        PROVINCIAS_CANTONES_DISTRITOS.put("Puntarenas", puntarenas);

        Map<String, List<String>> limon = new HashMap<>();
        limon.put("Limón", List.of("Limón Centro", "Valle la Estrella", "Pocora", "Río Blanco", "Siquirres", "La Rita"));
        limon.put("Guácimo", List.of("Guácimo Centro", "Los Chiles", "Palmar", "Hacienda", "San Vicente"));
        limon.put("Talamanca", List.of("Bribri", "Sixaola", "Cahuita", "Puerto Viejo", "Talamanca", "Limoncito"));
        limon.put("Matina", List.of("Matina Centro", "La Casona", "Jazmín", "La Lucha", "Monteverde"));

        PROVINCIAS_CANTONES_DISTRITOS.put("Limón", limon);
        
    }    

    public Cliente(long codigo, String nombre, String apellidos, int telefono, String correo, String provincia, String canton, String distrito, LocalDate fechaNacimiento) {
        if (!PROVINCIAS_CANTONES_DISTRITOS.containsKey(provincia)) {
            throw new IllegalArgumentException("Provincia inválida: " + provincia);
        }
        if (!PROVINCIAS_CANTONES_DISTRITOS.get(provincia).containsKey(canton)) {
            throw new IllegalArgumentException("Cantón inválido: " + canton);
        }
        if (!PROVINCIAS_CANTONES_DISTRITOS.get(provincia).get(canton).contains(distrito)) {
            throw new IllegalArgumentException("Distrito inválido: " + distrito);
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y setters
    public long getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre.trim(); }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos.trim(); }
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) {
        if (!PROVINCIAS_CANTONES_DISTRITOS.containsKey(provincia)) {
            throw new IllegalArgumentException("Provincia inválida: " + provincia);
        }
        this.provincia = provincia;
    }
    public String getCanton() { return canton; }
    public void setCanton(String canton) {
        if (!PROVINCIAS_CANTONES_DISTRITOS.get(provincia).containsKey(canton)) {
            throw new IllegalArgumentException("Cantón inválido: " + canton);
        }
        this.canton = canton;
    }
    public String getDistrito() { return distrito; }
    public void setDistrito(String distrito) {
        if (!PROVINCIAS_CANTONES_DISTRITOS.get(provincia).get(canton).contains(distrito)) {
            throw new IllegalArgumentException("Distrito inválido: " + distrito);
        }
        this.distrito = distrito;
    }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}



