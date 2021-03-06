/*******************************************************************************
* Copyright 2014 Ivan Shubin http://mindengine.net
* 
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* 
*   http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
******************************************************************************/
package net.mindengine.galen.suite.actions.javascript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class ScriptExecutor {
    
    private ScriptEngine engine;
    private String contextFolder;
    
    private Set<String> loadedFiles = new HashSet<String>();

    public ScriptExecutor(ScriptEngine engine, String contextFolder) {
        this.engine = engine;
        if (contextFolder != null && !contextFolder.isEmpty()) {
            this.contextFolder = contextFolder;
        }
        else { 
            this.contextFolder = ".";
        }
    }

    public void load(String filePath) throws FileNotFoundException, ScriptException {
        File file = new File(contextFolder + File.separator + filePath);
        String absolutePath = file.getAbsolutePath();
        
        if (!loadedFiles.contains(absolutePath)) {
            engine.eval(new FileReader(file));
            loadedFiles.add(absolutePath);
        }
    }
    
    public void print(String message) {
        System.out.print(message);
    }
    
    public void println(String message) {
        System.out.println(message);
    }

}
