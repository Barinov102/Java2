package Lesson1_Java2;

public class Main {

    public abstract class Animal implements Competitor {
        protected String type;
        protected String name;

        protected int maxRunDistance;
        protected int maxJumpHeight;
        protected int maxSwimDistance;

        protected boolean onDistance;

        @Override
        public boolean isOnDistance() {
            return onDistance;
        }

        public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
            this.type = type;
            this.name = name;
            this.maxRunDistance = maxRunDistance;
            this.maxJumpHeight = maxJumpHeight;
            this.maxSwimDistance = maxSwimDistance;
            this.onDistance = true;
        }

        @Override
        public void run(int dist) {
            if (dist <= maxRunDistance) {
                System.out.println(type + " " + name + " very good cross");
            } else {
                System.out.println(type + " " + name + " fail cross");
                onDistance = false;
            }
        }

        @Override
        public void jump(int height) {
            if (height <= maxJumpHeight) {
                System.out.println(type + " " + name + "Good jump for ");
            } else {
                System.out.println(type + " " + name + " Dont jump and go for distans");
                onDistance = false;
            }
        }

        @Override
        public void swim(int dist) {
            if (maxSwimDistance == 0) {
                System.out.println(type + " " + name + " Dont swim anf go for distans");
                onDistance = false;
                return;
            }
            if (dist <= maxSwimDistance) {
                System.out.println(type + " " + name + " good swim");
            } else {
                System.out.println(type + " " + name + " Dont swim anf go for distans");
                onDistance = false;
            }
        }

        @Override
        public void result() {
            System.out.println(type + " " + name + ": " + onDistance);
        }
    }



    public class Cat extends Animal {
        public Cat(String name) {
            super("Cat", name, 500, 5, 0);
        }
    }
    Footer
© 2022 GitHub, Inc.
            Footer navigation
    Terms
            Pr


    public interface Competitor {
        void run(int dist);

        void swim(int dist);

        void jump(int height);

        void result();

        boolean isOnDistance();
    }


    public class Course {

        private Obstacle[] obstacles;

        public Course(Obstacle... obstacles) {
            this.obstacles = obstacles;
        }

        public void doIt(Team team) {
            for (Competitor c : team.getCompetitors()) {
                for (Obstacle o : obstacles) {
                    o.doIt(c);
                    if (!c.isOnDistance()) break;
                }
            }
        }
    }

    public class Cross extends Obstacle {
        private int dist;

        public Cross(int dist) {
            this.dist = dist;
        }

        @Override
        public void doIt(Competitor competitor) {
            competitor.run(dist);
        }
    }


    public class Dog extends Animal {
        public Dog(String name) {
            super("Dog", name, 2000, 2, 20);
        }
    }

    public class Main {

        public static void main(String[] args) {

            Course course1 = new Course(new Cross(300),
                    new Cross(800), new Water(5));

            Team team1 = new Team("Team 1", new Cat("Barsik"),
                    new Dog("Bobik"), new Dog("Sharik"));


            course1.doIt(team1);


            public abstract class Obstacle {
                public abstract void doIt(Competitor competitor);
            }


            public class Team {

                private String teamName;
                private Competitor[] competitors;

                public Team(String teamName, Competitor... competitors) {
                    this.teamName = teamName;
                    this.competitors = competitors;
                }

                public Competitor[] getCompetitors() {
                    return competitors;
                }

                public void showResults() {
                    System.out.printf("%s info:\n", teamName);
                    for (Competitor competitor : competitors) {
                        competitor.result();
                    }
                }

                public void positiveInfo() {
                    System.out.printf("%s positive info:\n", teamName);
                    for (Competitor competitor : competitors) {
                        if (competitor.isOnDistance()) competitor.result();
                    }
                }
            }


            public class Water extends Obstacle {
                private int dist;

                public Water(int dist) {
                    this.dist = dist;
                }

                @Override
                public void doIt(Competitor competitor) {
                    competitor.swim(dist);
                }
            }
        }
