/*
 * Copyright (C) 2011 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.iq80.leveldb.impl;

import org.iq80.leveldb.util.Slice;

import java.io.File;
import java.io.IOException;

/**
 * The log file contents are a sequence of 32KB blocks. The only exception is that the tail of the file may contain a partial block.
 */
public interface LogWriter
{
    boolean isClosed();

    void close()
            throws IOException;

    void delete()
            throws IOException;

    File getFile();

    long getFileNumber();

    // Writes a stream of chunks such that no chunk is split across a block boundary
    void addRecord(Slice record, boolean force)
            throws IOException;
}
