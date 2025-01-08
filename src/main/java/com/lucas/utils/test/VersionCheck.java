package com.lucas.utils.test;

public class VersionCheck {
    /**
     * Compare two versions.
     * @param version1
     * @param version2
     * @return
     *
     * version1 이 version2 보다 높으면 = 1
     * version1 이 version2 보다 낮으면 = -1
     * version1 과 version2 가 같으면 = 0
     */
    public static int compareVersions(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            int v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            int v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            if (v1 < v2) {
                return -1;
            }
            if (v1 > v2) {
                return 1;
            }
        }

        return 0; // Versions are equal
    }

    public static void main(String[] args) {
        String resultMsg;
        String version1 = "2.1.0";
        String version2 = "1.3.0";

        int result = compareVersions(version1, version2);
        System.out.println("result = " + result);
        if (result < 0) {
            resultMsg = "version1 is Less";
            System.out.println(version1 + " is less than " + version2);
        } else if (result > 0) {
            resultMsg = "version1 is Greater";
            System.out.println(version1 + " is greater than " + version2);
        } else {
            resultMsg = "versions are Equal";
            System.out.println(version1 + " is equal to " + version2);
        }

        System.out.println("resultMsg = " + resultMsg);
    }
}
