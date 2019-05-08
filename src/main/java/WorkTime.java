interface WorkTime {
    default int payWorktime(short base, short worktime){
        return base*worktime;
    }
}

interface Project  {
    default int payProject (byte percent, String project){
        int costProject = 0;
        if ("Java database".equals(project)){
            costProject = 1000000;
        }
        else if ("Typescript".equals(project)){
            costProject = 500000;
        }
        else if ("C++".equals(project)){
            costProject = 1500000;
        }

        return (costProject/100)*percent;
    }
}

interface Heading {
    default int payHeading(byte numberEmployees){
        int taxHeading = 10000;
        return numberEmployees*taxHeading;
    }
}

