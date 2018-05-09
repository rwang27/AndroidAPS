package info.nightscout.androidaps.startupwizard;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SWFragment extends SWItem {
    private static Logger log = LoggerFactory.getLogger(SWFragment.class);

    SWDefinition definition;
    Fragment fragment;

    public SWFragment(SWDefinition definition) {
        super(Type.FRAGMENT);
        this.definition = definition;
    }

    public SWFragment add(Fragment fragment) {
        this.fragment = fragment;
        return this;
    }

    @Override
    public void generateDialog(View view, LinearLayout layout) {
        definition.getActivity().getSupportFragmentManager().beginTransaction().add(layout.getId(), fragment, fragment.getTag()).commit();
    }

}
