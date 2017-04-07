package uo.sdi.presentation;

import java.util.Iterator;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import uo.sdi.dto.Task;

public class TaskList extends ListDataModel<Task> implements
		SelectableDataModel<Task> {

	public TaskList(List<Task> tareas) {
		this.setWrappedData(tareas);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Task getRowData(String rowKey) {
		Iterator<Task> iter = ((List<Task>) this.getWrappedData()).iterator();
		while (iter.hasNext()) {
			Task item = iter.next();
			if (item.getId().toString().equals(rowKey)) {
				return item;
			}
		}

		return null;
	}

	@Override
	public Object getRowKey(Task arg0) {
		return arg0.getId();
	}
}
