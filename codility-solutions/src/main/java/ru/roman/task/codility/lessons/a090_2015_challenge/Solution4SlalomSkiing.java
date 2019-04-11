package ru.roman.task.codility.lessons.a090_2015_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * You are a skier participating in a giant slalom. The slalom track is located on a ski slope, goes downhill and is fenced by barriers on both sides. The barriers are perpendicular to the starting line located at the top of the slope. There are N slalom gates on the track. Each gate is placed at a distinct distance from the starting line and from the barrier on the right-hand side (looking downhill).
 * <p>
 * You start from any place on the starting line, ski down the track passing as many gates as possible, and finish the slalom at the bottom of the slope. Passing a gate means skiing through the position of the gate.
 * <p>
 * You can ski downhill in either of two directions: to the left or to the right. When you ski to the left, you pass gates of increasing distances from the right barrier, and when you ski to the right, you pass gates of decreasing distances from the right barrier. You want to ski to the left at the beginning.
 * <p>
 * Unfortunately, changing direction (left to right or vice versa) is exhausting, so you have decided to change direction at most two times during your ride. Because of this, you have allowed yourself to miss some of the gates on the way down the slope. You would like to know the maximum number of gates that you can pass with at most two changes of direction.
 * <p>
 * The arrangement of the gates is given as an array A consisting of N integers, whose elements specify the positions of the gates: gate K (for 0 ≤ K < N) is at a distance of K+1 from the starting line, and at a distance of A[K] from the right barrier.
 * <p>
 * For example, consider array A such that:
 * <pre>
 * A[0] = 15
 * A[1] = 13
 * A[2] = 5
 * A[3] = 7
 * A[4] = 4
 * A[5] = 10
 * A[6] = 12
 * A[7] = 8
 * A[8] = 2
 * A[9] = 11
 * A[10] = 6
 * A[11] = 9
 * A[12] = 3</pre>
 * <p>
 * The picture above illustrates the example track with N = 13 gates and a course that passes eight gates. After starting, you ski to the left (from your own perspective). You pass gates 2, 3, 5, 6 and then change direction to the right. After that you pass gates 7, 8 and then change direction to the left. Finally, you pass gates 10, 11 and finish the slalom. There is no possible way of passing more gates using at most two changes of direction.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, describing the positions of the gates on the track, returns the maximum number of gates that you can pass during one ski run.
 * <p>
 * For example, given the above data, the function should return 8, as explained above.
 * <p>
 * For the following array A consisting of N = 2 elements:
 * <pre>
 * A[0] = 1
 * A[1] = 5</pre>
 * the function should return 2.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * the elements of A are all distinct.
 */
class Solution4SlalomSkiing {

    private static boolean log = false;
    private static boolean withTimePoints = true;
    private static long time;
    private static Map<String, Long> timePoints;

    public int solution(int[] A) {
        log("On input: " + Arrays.toString(A));
        startTime();

        List<Gate> gatesColumn = prepareColumn(A);
        timePoint("prepareColumn");
        List<Gate> gatesRow = prepareRow(gatesColumn);
        log("Gates row: " + gatesRow);
        timePoint("prepareRow");

        prepareGraph(gatesColumn, gatesRow);
        log("Graph: " + gatesColumn);
        timePoint("prepareGraph");

        Set<Path> paths = prepareStartingPoints(gatesRow);
        log("Starting points: " + paths);
        timePoint("prepareStartingPoints");

        int result = calcMaxGates(paths);
        timePoint("calcMaxGates");
        logTimePoints();
        return result;
    }

    private int calcMaxGates(Set<Path> paths) {

        int maxGates = 0;
        final LinkedList<Path> queue = new LinkedList<>(paths);

        while (!queue.isEmpty()) {

            Path path = queue.pop();

            log("\t\t\t\t=>: %s, max=%s", path, maxGates);

            boolean end = path.pushNext(queue);
            if (end) {
                maxGates = Math.max(maxGates, path.count);

                log("Child exhausting: %s, max=%s", path, maxGates);
            }
        }

        return maxGates;
    }

    private Set<Path> prepareStartingPoints(List<Gate> gates) {
        int[] i = new int[]{gates.size()};
        Set<Path> res = gates.stream()
                .filter(gate -> {
                    boolean less = gate.index < i[0];
                    if (less) {
                        i[0] = gate.index;
                    }
                    return less;
                })
                .map(gate -> new Path(gate, null, true, 1))
                .collect(Collectors.toCollection(HashSet::new));

        i[0] = gates.size();
        Collections.reverse(gates);

        res.addAll(gates.stream()
                .filter(gate -> {
                    boolean less = gate.index < i[0];
                    if (less) {
                        i[0] = gate.index;
                    }
                    return less;
                })
                .map(gate -> new Path(gate, null, true, 1))
                .collect(Collectors.toList()));
        return res;
    }

    private void prepareGraph(List<Gate> column, List<Gate> row) {
        for (Gate g : column) {
            int closestRight = -1;
            int closestLeft = row.size();

            for (Gate subGate : column.subList(g.index + 1, column.size())) {
                if (closestRight < subGate.value && g.isLeftTo(subGate)) {
                    g.rights.add(subGate);
                    closestRight = subGate.value;
                } else if (closestLeft > subGate.value && !g.isLeftTo(subGate)) {
                    g.lefts.add(subGate);
                    closestLeft = subGate.value;
                }
                if (closestRight == g.value - 1 && closestLeft == g.value + 1) {
                    break;
                }
            }
        }
    }

    /**
     * Binary search not appropriate, because all gates must be sorted on one order, according to one criteria,
     * but we have two, value and index
     */
    private static Gate searchRightest(List<Gate> list, Gate parentGate, int highestRightVal) {
        int beg = 0, end = list.size() - 1;

        Gate res = null, gate;
        for (int mid; beg <= end; ) {
            mid = (beg + end) / 2;
            gate = list.get(mid);
            if (
                    highestRightVal < gate.value
                            && parentGate.isLeftTo(gate)
                            && parentGate.index < gate.index) {
                res = gate;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return res;
    }

    private List<Gate> prepareRow(List<Gate> gatesColumn) {
        List<Gate> list = new ArrayList<>(new TreeSet<>(gatesColumn));
        for (int i = 0; i < list.size(); i++) {
            list.get(i).value = i;
        }
        return list;
    }

    private List<Gate> prepareColumn(int[] A) {
        List<Gate> list = new ArrayList<>(A.length);
        for (int i = 0; i < A.length; i++) {
            Gate g = new Gate();
            g.index = i;
            g.value = A[i];
            list.add(g);
        }
        return list;
    }

    private static class Gate implements Comparable {
        private int index;
        private int value;
        private final Set<Gate> rights = new HashSet<>();
        private final Set<Gate> lefts = new HashSet<>();
        private final LinkedList<Record> records = new LinkedList<>();

        boolean isLeftTo(Gate g) {
            return this.compareTo(g) > 0;
        }

        @Override
        public boolean equals(Object o) {
            return index == ((Gate) o).index;
        }

        @Override
        public int hashCode() {
            return index;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.value, ((Gate) o).value);
        }

        @Override
        public String toString() {
            StringJoiner joiner = new StringJoiner(",", "\n\t" + getClass().getSimpleName() + "[", "]")
                    .add("i=" + index)
                    .add("v=" + value);
            for (Gate g : rights) {
                joiner.add("R[i=" + g.index)
                        .add("v=" + g.value + "]");
            }
            for (Gate g : lefts) {
                joiner.add("L[i=" + g.index)
                        .add("v=" + g.value + "]");
            }
            return joiner.toString();
        }
    }

    private static class Path {
        private final Gate gate;
        private final boolean left;
        private final int count;
        private final int turns;
        private boolean exhausted = false;

        Path(Gate gate, Path prev, boolean left, int count) {
            this.gate = gate;
            this.left = left;
            this.count = count;
            this.turns = prev == null ? 0 : prev.left == left ? prev.turns : prev.turns + 1;
        }

        @Override
        public boolean equals(Object o) {
            return gate.equals(((Path) o).gate);
        }

        @Override
        public int hashCode() {
            return gate.hashCode();
        }

        boolean pushNext(LinkedList<Path> queue) {
            if (exhausted) {
                return true;
            }
            boolean notEmpty = false;
            if (turns < 2 || (turns == 2 && left)) {
                for (Gate gate : gate.lefts) {
                    Path p = new Path(gate, this, true, count + 1);
                    if (!p.isBeaten()) {
                        queue.push(p);
                        notEmpty = true;
                    } else {
                        log("%s beaten by records: %s", p, p.gate.records);
                    }
                }
            }
            if (turns < 2 || (turns == 2 && !left)) {
                for (Gate gate : gate.rights) {
                    Path p = new Path(gate, this, false, count + 1);
                    if (!p.isBeaten()) {
                        queue.push(p);
                        notEmpty = true;
                    } else {
                        log("%s beaten by records: %s", p, p.gate.records);
                    }
                }
            }
            exhausted = !notEmpty;
            return exhausted;
        }

        private boolean isBeaten() {
            final Record r = new Record(count, turns, left);

            Iterator<Record> itr = gate.records.iterator();
            while (itr.hasNext()) {
                Record record = itr.next();

                if (r.isBeatenBy(record)) {
                    return true;
                } else if (record.isBeatenBy(r)) {
                    itr.remove();
                    gate.records.push(r);
                    return false;

                }
            }
            gate.records.push(r);
            return false;
        }

        @Override
        public String toString() {
            return "Path{" +
                    "i=" + gate.index +
                    " v=" + gate.value +
                    " l=" + left +
                    " c=" + count +
                    " t=" + turns +
                    '}';
        }
    }

    private static class Record {
        private final int count;
        private final int turns;
        private final boolean left;

        private Record(int count, int turns, boolean left) {
            this.count = count;
            this.turns = turns;
            this.left = left;
        }

        boolean isBeatenBy(Record r) {
            return left == r.left && count <= r.count && r.turns <= turns;
        }

        @Override
        public String toString() {
            return "Rec{" +
                    "c=" + count +
                    " t=" + turns +
                    " l=" + left +
                    '}';
        }
    }

    static void log(String str, Object... params) {
        if (log)
            System.out.printf(str + "\n", params);
    }

    static void startTime() {
        if (withTimePoints) {
            timePoints = new LinkedHashMap<>();
            time = System.currentTimeMillis();
        }
    }

    static void timePoint(String str) {
        if (withTimePoints) {
            long t = System.currentTimeMillis();
            timePoints.put(str, t - time);
            time = t;
        }
    }

    static void logTimePoints() {
        if (withTimePoints) {
            System.out.println("Time Points: " + timePoints);
        }
    }
}
