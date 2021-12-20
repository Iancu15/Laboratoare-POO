public class Student implements Comparable<Student> {
    private Long id;
    private String name;
    private String surname;
    private Double averageGrade;

    public Student(long id, String name, String surname, double averageGrade) {
        this.id = id; 
        this.name = name;
        this.surname = surname;
        this.averageGrade = averageGrade;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAverageGrade() {
        return this.averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
    
    @Override
    public int compareTo(Student o) {
        if (this.averageGrade.equals(o.averageGrade)) {
            if (this.surname.equals(o.surname)) {
                return this.name.compareTo(o.name);
            }
            
            return this.surname.compareTo(o.name);
        }
        
        return this.averageGrade.compareTo(o.averageGrade);
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", averageGrade=" + averageGrade + "]\n";
    }
    
    /***
     * Ma folosesc doar de campurile specifice studentului si care nu se schimba
     * Nota ar strica HashCode-ul pentru ca e foarte probabil ca 2 studenti sa aiba aceeasi nota
     * fiind doar 10 optiuni
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    
    /***
     * Daca au acelasi id sigur sunt aceeasi studenti
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        Student other = (Student) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        
        return true;
    }
}