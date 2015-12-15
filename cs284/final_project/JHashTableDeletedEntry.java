public class JHashTableDeletedEntry extends JHashTableEntry {
      private static JHashTableDeletedEntry entry = null;

      private JHashTableDeletedEntry() {
            super(-1, null);
      }

      public static JHashTableDeletedEntry getADeletedEntry() {
            if (entry == null)
                  entry = new JHashTableDeletedEntry();
            return entry;
      }
}
