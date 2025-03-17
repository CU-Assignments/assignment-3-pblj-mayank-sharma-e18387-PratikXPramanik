class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class EnrollmentSystem {
    private static boolean isCourseFull = false;
    private static boolean prerequisiteMet = false;
    
    public static void enroll(String course, String prerequisite) throws CourseFullException, PrerequisiteNotMetException {
        if (isCourseFull) {
            throw new CourseFullException("Error: Course is full.");
        }
        if (!prerequisiteMet) {
            throw new PrerequisiteNotMetException("Error: Complete " + prerequisite + " before enrolling in " + course + ".");
        }
        System.out.println("Enrollment successful in: " + course);
    }
    
    public static void main(String[] args) {
        try {
            enroll("Advanced Java", "Core Java");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
