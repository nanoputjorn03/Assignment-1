/*Tat Putjorn 672115024 */

class StudentsName {
    private String SID;
    private String firstname;
    private String lastname;

    public StudentsName(String SID, String Firstname, String Lastname) {
        this.SID = SID;
        this.firstname = Firstname;
        this.lastname = Lastname;
    }

    public String getSID() {
        return SID;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    @Override
    public String toString() {
        return this.SID + " " + this.firstname + " " + this.lastname;
    }
}

