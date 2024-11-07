package week01_array;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class test07 {

    public static void main(String[] args) {
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs) {
        String[] kDirs = dirs.split("");
        Set<String> set = new LinkedHashSet<>();

        int x = 0;
        int y = 0;

        for (String dir : kDirs) {
            int nx = 0;
            int ny = 0;

            if (Objects.equals(dir, "U")) {
                ny = y + 1;
            } else if (Objects.equals(dir, "D")) {
                ny = y - 1;
            } else if (Objects.equals(dir, "R")) {
                nx = x + 1;
            } else if (Objects.equals(dir, "L")) {
                nx = x - 1;
            } else {
                throw new IllegalArgumentException();
            }

            if (!isValid(nx, ny)) {
                continue;
            }

            set.add(x + " " + y + " " + nx + " " + ny);

            x = nx;
            y = ny;
        }
        for (String s : set) {
            System.out.println(s);
        }
        return set.size();
    }

    public static boolean isValid(int nx, int ny) {
        return -5 <= nx && nx <= 5 && -5 <= ny && ny <= 5;
    }
}

//    public static int solution(String dirs) {
//        String[] kDirs = dirs.split("");
//        Set<Movement> movementSet = new LinkedHashSet<>();
//
//        Movement current = new Movement(0, 0, 0, 0);
//        Movement next;
//
//        for (String dir : kDirs) {
//            if (Objects.equals(dir, "U")) {
//                next = new Movement(current.currentX, current.currentY, current.nextX, current.nextY + 1);
//            } else if (Objects.equals(dir, "D")) {
//                next = new Movement(current.currentX, current.currentY, current.nextX, current.nextY - 1);
//            } else if (Objects.equals(dir, "R")) {
//                next = new Movement(current.currentX, current.currentY, current.nextX + 1, current.nextY);
//            } else if (Objects.equals(dir, "L")) {
//                next = new Movement(current.currentX, current.currentY, current.nextX - 1, current.nextY);
//            } else {
//                throw new IllegalArgumentException();
//            }
//
//            if (!isValid(next)) {
//                continue;
//            }
//
//            movementSet.add(next);
//
//            current.setCurrentX(next.nextX);
//            current.setCurrentY(next.nextY);
//            current.setNextX(next.nextX);
//            current.setNextY(next.nextY);
//        }
//
//        movementSet.removeIf(movement ->
//                movement.currentX < -5 || movement.currentX > 5 ||
//                        movement.currentY < -5 || movement.currentY > 5 ||
//                        movement.nextX < -5 || movement.nextX > 5 ||
//                        movement.nextY < -5 || movement.nextY > 5
//        );
//
//        return movementSet.size();
//    }
//
//    public static boolean isValid(Movement movement) {
//        if (movement.nextX < -5) {
//            return false;
//        } else if (movement.nextX > 5) {
//            return false;
//        } else if (movement.nextY < -5) {
//            return false;
//        } else if (movement.nextY > 5) {
//            return false;
//        }
//
//        if (movement.currentX < -5) {
//            return false;
//        } else if (movement.currentX > 5) {
//            return false;
//        } else if (movement.currentY < -5) {
//            return false;
//        } else if (movement.currentY > 5) {
//            return false;
//        }
//
//        return true;
//    }
//
//    public static class Movement {
//        public int currentX;
//        public int currentY;
//        public int nextX;
//        public int nextY;
//
//        public Movement(int currentX, int currentY, int nextX, int nextY) {
//            this.currentX = currentX;
//            this.currentY = currentY;
//            this.nextX = nextX;
//            this.nextY = nextY;
//        }
//
//        public int getCurrentX() {
//            return currentX;
//        }
//
//        public void setCurrentX(int currentX) {
//            this.currentX = currentX;
//        }
//
//        public int getCurrentY() {
//            return currentY;
//        }
//
//        public void setCurrentY(int currentY) {
//            this.currentY = currentY;
//        }
//
//        public int getNextX() {
//            return nextX;
//        }
//
//        public void setNextX(int nextX) {
//            this.nextX = nextX;
//        }
//
//        public int getNextY() {
//            return nextY;
//        }
//
//        public void setNextY(int nextY) {
//            this.nextY = nextY;
//        }
//
//        @Override
//        public String toString() {
//            return "Movement{" +
//                    "currentX=" + currentX +
//                    ", currentY=" + currentY +
//                    ", nextX=" + nextX +
//                    ", nextY=" + nextY +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Movement movement = (Movement) o;
//            return currentX == movement.currentX && currentY == movement.currentY && nextX == movement.nextX && nextY == movement.nextY;
//        }
//
//        @Override
//        public int hashCode() {
//            int result = currentX;
//            result = 31 * result + currentY;
//            result = 31 * result + nextX;
//            result = 31 * result + nextY;
//            return result;
//        }
//    }
//}
