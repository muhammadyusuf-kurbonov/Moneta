
package harshbarash.github.io.customview;

import harshbarash.github.io.tflite.Classifier.Recognition;

import java.util.List;

public interface ResultsView {
  public void setResults(final List<Recognition> results);
}
